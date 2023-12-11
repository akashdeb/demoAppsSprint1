package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(tagName = "h1")
	private WebElement loginPageHeader;
	
	@FindBy(id = "email")
	private WebElement emailTextField;
	
	@FindBy(id = "password")
	private WebElement passwordTextField;
	
	@FindBy(tagName = "button")
	private WebElement loginButton;

	@FindBy(xpath = "//div[text()='Signin successful']")
	private WebElement loginSuccessfulMsg;

	
	public WebElement getLoginPageHeader() {
		return loginPageHeader;
	}
		

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	
	public WebElement getLoginSuccessfulMsg() {
		return loginSuccessfulMsg;
	}


	public void loginAction(String email, String password) {
		emailTextField.clear();
		emailTextField.sendKeys(email);
		passwordTextField.clear();
		passwordTextField.sendKeys(password);
		loginButton.click();
		
	}
	
	public String verifyLoginPage() {
		return loginPageHeader.getText();
	}
	
	public boolean loginSucessMsgDisplay() {
		 return loginSuccessfulMsg.isDisplayed();
	}

}
