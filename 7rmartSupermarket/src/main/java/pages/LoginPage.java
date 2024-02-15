package pages;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	@FindBy(xpath="//input[@name='username']")private WebElement userNameField;
	@FindBy(xpath="//input[@placeholder='Password']")private WebElement passWordField;
	@FindBy(xpath="//button[@type='submit']")private WebElement signInButton;
	@FindBy(xpath="//li[text()='Dashboard']")private WebElement dashBoard;
	@FindAll({@FindBy(xpath = "//a[@class='small-box-footer']")})private List<WebElement> dashboardTiles;
	@FindBy(xpath = "//div[contains(@class,'alert-danger')]")private WebElement alert;

	public LoginPage(WebDriver driver) {
	this.driver =driver;
	PageFactory.initElements(driver,this );

	}
	
	public void navigateToAPage(String url) {
		
		for(WebElement tile:dashboardTiles) {
			if(tile.getAttribute("href").equals(url)) {
				 JavascriptExecutor executor = (JavascriptExecutor)driver;
				 executor.executeScript("arguments[0].click();", tile);
				break;
			}
		}
	}
	public void enterUserNameOnUserNameField(String username) {
	
		userNameField.sendKeys(username);
	}

	public void enterPassWordOnPassWordFeild(String password) {
	
		
		passWordField.sendKeys(password);
	}
	public void clickOnSignInButton() {
		signInButton.click();
	}
	public boolean isDashBoardLoaded() {
		return dashBoard.isDisplayed();
	}
	public boolean isAlertVisible() {
		return alert.isDisplayed();
	}
}
