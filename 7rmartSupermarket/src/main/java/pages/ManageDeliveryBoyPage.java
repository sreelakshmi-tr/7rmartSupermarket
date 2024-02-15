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
	@FindBy(xpath = "//a[@onclick='click_button(2)']")private WebElement searchMenuButton;
	@FindBy(xpath = "//input[@placeholder='Email']")private WebElement emailField;
	@FindBy(xpath = "//input[@placeholder='Name']")private WebElement nameField;
	@FindBy(xpath = "//input[contains(@placeholder,'Phone')]")private WebElement phoneNumberField;
	@FindBy(xpath = "//button[@name='Search']")private WebElement searchSubmitButton;
	@FindBy(xpath = "//a[text()='Reset']")private WebElement ResetSubmitButton;
	@FindBy(xpath = "//table//center")private WebElement resultNotFoundMessage;
	@FindBy(xpath = "//table//td[5]")private WebElement resultFound;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")private WebElement newButton;
	@FindBy(xpath = "//input[@placeholder='Enter the Name']")private WebElement newName;
    @FindBy(xpath = "//button[text()='Save']")private WebElement saveButton;
    @FindBy(xpath = "//div[contains(@class,'alert-success')]")private WebElement addSuccessAlert;
    @FindBy(xpath = "//input[@id='username']")private WebElement newUserNameField;
    @FindBy(xpath = "//table//tbody//tr[1]//td[6]")private WebElement statusButton;
    @FindBy(xpath = "//button[@data-dismiss=\"alert\"]")private WebElement alert;
    @FindBy(xpath = "//table//tbody//tr[1]//td[8]//a[2]")private WebElement firstRowDeleteButton;
	
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
		waitUtility.waitForClick(driver, saveButton);	 
	    pageUtility.elementClickUsingJavascriptExecutor(driver, saveButton);
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
    
    public void deleteFirstRow() {
		pageUtility.elementClickUsingJavascriptExecutor(driver, firstRowDeleteButton);
	}
    
    public void confirmDelete() {
		pageUtility.acceptAlert(driver);
	}
    
    public boolean isDeliveryBoyDeleted() {
		waitUtility.waitForElement(driver, alert);
		return alert.isDisplayed();
	}
	
}
