package webElement.textfield;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtils.BaseClass;
import pomRepo.LoginPage;
import pomRepo.RegisterPage;

public class RegisterUserAndLoginTest extends BaseClass {
	
	@Test(priority = 1)
	public void registerUserAndVerifyTest() throws EncryptedDocumentException, IOException {
		
		String name = fUtils.fetchStringDataFromExcelFile("Register", 1, 0);
		String email = fUtils.fetchStringDataFromExcelFile("Register", 1, 1);
		String password = fUtils.fetchStringDataFromExcelFile("Register", 1, 2);
		String expectedLoginPageContent = fUtils.fetchStringDataFromExcelFile("Register", 1, 3);

		
		RegisterPage register = new RegisterPage(driver);
		register.registerAction(name, email, password);
		
		LoginPage login = new LoginPage(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(login.getLoginPageHeader()));
		
		String actualLoginPageContent = login.verifyLoginPage();
		
		Assert.assertEquals(actualLoginPageContent, expectedLoginPageContent);
		System.out.println("Pass: user has registered");

	}
	
	@Test(priority = 2)
	public void loginUserAndVerify() throws EncryptedDocumentException, IOException {
		
		String email = fUtils.fetchStringDataFromExcelFile("Login", 1, 0);
		String password = fUtils.fetchStringDataFromExcelFile("Login", 1, 1);
		boolean expectedLoginStatus = fUtils.fetchBooleanDataFromExcelFile("Login", 1, 2);
		
		LoginPage login = new LoginPage(driver);
		
		login.loginAction(email, password);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(login.getLoginSuccessfulMsg()));
			
		boolean actualLoginStatus = login.loginSucessMsgDisplay();
		
		Assert.assertEquals(actualLoginStatus, expectedLoginStatus);
		System.out.println("Pass: the user has logged in");

	}

}
