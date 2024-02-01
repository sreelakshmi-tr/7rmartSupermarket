package testscript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Base {
	public WebDriver driver;
	
	@BeforeMethod (alwaysRun = true)
	@Parameters("browser")
	public void inititializeBrowser(String browser) throws Exception {
		
		
		if(browser.equalsIgnoreCase("Chrome")) {
		  driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}else if(browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}else {
			throw new Exception("Browser is not correct");
		}
		
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		
		driver.manage().window().maximize();
		
	}
	
	@AfterMethod
	public void driverQuit() {
		driver.quit();
	}

}
