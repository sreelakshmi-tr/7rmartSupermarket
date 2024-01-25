package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;
import utilities.RandomInputUtility;
import utilities.WaitUtility;


public class ManageDeliveryBoyPage {
	WebDriver driver;
	PageUtility pageUtility;
	RandomInputUtility randomInputUtility;
	WaitUtility waitUtility;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")WebElement searchMenuButton;
	@FindBy(xpath = "//input[@placeholder='Email']")WebElement emailField;
	@FindBy(xpath = "//input[@placeholder='Name']")WebElement nameField;
	@FindBy(xpath = "//input[contains(@placeholder,'Phone')]")WebElement phoneNumberField;
	@FindBy(xpath = "//button[@name='Search']")WebElement searchSubmitButton;
	@FindBy(xpath = "//a[text()='Reset']")WebElement ResetSubmitButton;
	@FindBy(xpath = "//table//center")WebElement resultNotFoundMessage;
	@FindBy(xpath = "//table//td[5]")WebElement resultFound;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")WebElement newButton;
	@FindBy(xpath = "//input[@placeholder='Enter the Name']")WebElement newName;
    @FindBy(xpath = "//button[text()='Save']")WebElement saveButton;
    @FindBy(xpath = "//div[contains(@class,'alert-success')]")WebElement addSuccessAlert;
    @FindBy(xpath = "//input[@id='username']")WebElement newUserNameField;
    @FindBy(xpath = "//table//tbody//tr[1]//td[6]")WebElement statusButton;
    @FindBy(xpath = "//button[@data-dismiss=\"alert\"]")WebElement alert;
	
	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this );
		pageUtility = new PageUtility();
		randomInputUtility = new RandomInputUtility();
		waitUtility = new WaitUtility();
	}
	
	
	public void clickOnsearchMenuButton() {
		searchMenuButton.click();
	}
	
	public void clickOnSearchSubmitButton() {
		searchSubmitButton.click();
	}
	
	
	public void clickOnResetSubmitButton() {
		ResetSubmitButton.click();
	}
    public void enterEmailOnEmailField(String email) {	
		
		 emailField.sendKeys(email);
	}
    public void enterNameOnNameField(String name) {	
		
		 nameField.sendKeys(name);
	}
    public void enterPhoneNumberOnPhoneNumberField(String phoneNumber) {
    	 if(phoneNumber==null)
    		 phoneNumber= randomInputUtility.randomPhoneNumberGenerator();
		
		 phoneNumberField.sendKeys(phoneNumber);
	}
   
    public boolean isResultNotFoundMessageVisible() {
    	return resultNotFoundMessage.isDisplayed();
    }
    
    public boolean isResultAvailable() {
    	return resultFound.isDisplayed();
    }
    
    public boolean isNewDeliveryBoyCreated() {
    	return addSuccessAlert.isDisplayed();
    }
    public void clickOnNewButton() {
    	newButton.click();
    }
    
    public void enterNewNameOnTheForm() {
    	String name = randomInputUtility.randomFullNameGenerator();
    	newName.sendKeys(name);

    }
    
    public boolean isNewUserNameFieldEmplty() {
    	return newUserNameField.getText().isEmpty();
    }
    
    public void clickOnSaveButton() {
    	pageUtility.scrollBy(driver);
		pageUtility.waitForClick(driver, saveButton);	 
	    pageUtility.elementClick(driver, saveButton);
    }
    
    public void clickOnStatusButton() {
    	waitUtility.waitForElement(driver, statusButton);
		statusButton.click();
	}
    public String currentStatus() {
    	return statusButton.getText();
	}
    public boolean isSuccessAlertVisible() {
		waitUtility.waitForElement(driver, alert);
		return alert.isDisplayed();
	}
	
}
