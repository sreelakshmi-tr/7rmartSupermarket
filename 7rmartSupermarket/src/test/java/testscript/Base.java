package testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constants;
import utilities.ScreenShotUtility;

public class Base {
	public WebDriver driver;
	public ScreenShotUtility scrshot;
	public Properties properties;
	public FileInputStream fileInputStream;
	
	@BeforeMethod (alwaysRun = true)
	@Parameters("browser")
	public void inititializeBrowser(String browser) throws Exception {
		
		try {
			 properties = new Properties();
			 fileInputStream = new FileInputStream(Constants.CONFIGFILE);
			properties.load(fileInputStream);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		if(browser.equalsIgnoreCase("Chrome")) {
		  driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}else if(browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}else {
			throw new Exception("Browser is not correct");
		}
		
		driver.get(properties.getProperty("url"));
		
		driver.manage().window().maximize();
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void browserQuit(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			scrshot = new ScreenShotUtility();
			scrshot.getScreenShot(driver, iTestResult.getName());
		}

		driver.quit();
	}
}
