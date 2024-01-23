package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;
import utilities.RandomInputUtility;

public class AdminUsersPage {
    WebDriver driver;
    PageUtility pageUtility;
    RandomInputUtility randomInputUtility;
    @FindBy(xpath = "//a[@onclick='click_button(1)']")WebElement newButton;
    @FindBy(xpath = "//a[@onclick='click_button(2)']")WebElement searchButton;
    @FindBy(xpath = "//input[@id='username']")WebElement userNameField;
    @FindBy(xpath = "//input[@id='password']")WebElement passwordField;
    @FindBy(xpath = "//select[@name='user_type']//child::option")List<WebElement> userTypeOptions;
    @FindBy(xpath = "//button[@name='Create']")WebElement saveButton;
    @FindBy(xpath = "//div[contains(@class,'card-footer center')]//a[text()='Reset']")WebElement formResetButton;
    @FindBy(xpath = "//div[contains(@class,'alert-success')]")WebElement successAlert;


    
	public AdminUsersPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this );
        pageUtility = new PageUtility();
        randomInputUtility = new RandomInputUtility(); 
		}
	
	public void clickOnNewButton() {
		newButton.click();
	}
	
    public void clickOnSaveButton() {
		saveButton.click();
	}
    
    public void clickOnResetButton() {
		formResetButton.click();
	}
    
    public void enterUserNameOnUserNameField(String username) {
    	
		userNameField.sendKeys(username);
	}
    
    public void enterPassWordOnPassWordField(String password) {
    	
		passwordField.sendKeys(password);
	}
    
    public String getNewPassword() {
    	
		return randomInputUtility.randomPasswordGenerator();
	}
    
    public String getNewUserName() {
    	
		return randomInputUtility.randomFirstNameGenerator();
	}
    
    public void selectUserType(String expectedUserType) {
    	
		for(WebElement userType:userTypeOptions) {
			if(expectedUserType.equals(userType.getText())){
				userType.click();
			}
		}
	}
    
    public boolean isSuccessAlertVisible() {
    	
    	return successAlert.isDisplayed();
    }
}
