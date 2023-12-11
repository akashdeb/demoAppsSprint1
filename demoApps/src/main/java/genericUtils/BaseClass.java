package genericUtils;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	public WebDriver driver ;
	public FileUtility fUtils = new FileUtility();
	
	@BeforeClass
	public void bc() throws IOException {
		
		String browser = fUtils.fetchDataFromPropertyFile("browser");
		String url = fUtils.fetchDataFromPropertyFile("url");
		
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		
		else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		
		else if(browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
	}
	
	@AfterClass
	public void ac() {
		driver.quit();
	}
}
