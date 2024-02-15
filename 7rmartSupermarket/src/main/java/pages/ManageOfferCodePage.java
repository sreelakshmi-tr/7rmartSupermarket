package pages;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.RandomInputUtility;


public class ManageOfferCodePage {
	  WebDriver driver;
	    PageUtility pageUtility;
	    RandomInputUtility randomInputUtility;
	    FileUploadUtility fileUploadUtility;
	    @FindBy(xpath = "//a[@onclick='click_button(1)']")private WebElement newButton;
	    @FindBy(xpath = "//input[@id='offer_code']")private WebElement offerCodeField;
	    @FindBy(xpath = "//input[@value='yes']")private WebElement radioButtonYes;
	    @FindBy(xpath = "//input[@placeholder='Percentage']")private WebElement percentageField;
	    @FindBy(xpath = "//input[@placeholder='Amount']")private WebElement amountField;
	    @FindBy(xpath = "//div[@role='textbox']")private WebElement descriptionField;
        @FindBy(xpath = "//input[@id='main_img']")private WebElement chooseFile;
        @FindBy(xpath = "//button[@name='create']")private WebElement saveButton;
        @FindBy(xpath = "//button[@data-dismiss='alert']")private WebElement alert;

	    public ManageOfferCodePage(WebDriver driver) {
			this.driver =driver;
			PageFactory.initElements(driver,this );
	        pageUtility = new PageUtility();
	        randomInputUtility = new RandomInputUtility(); 
	        fileUploadUtility = new FileUploadUtility();
		}
	    
	    public void check() {
	       WebElement e= driver.findElement(By.xpath("//input[@id='main_img']"));
		}
	    public void clickOnNewButton() {
			pageUtility.elementClickUsingJavascriptExecutor(driver, newButton);
		}
	    
	    public void enterValueToNewOfferCode() {
	    	
	    	offerCodeField.sendKeys(randomInputUtility.randomPasswordGenerator());
		}
	    
	    public void clickOnRadioButtonYes() {
			pageUtility.elementClickUsingJavascriptExecutor(driver, radioButtonYes);
		}
	    
	    public void clickOnSaveButton() {
	    	pageUtility.elementClickUsingJavascriptExecutor(driver, saveButton);
			
		}
	    public void enterValueToPercentageField(String percentage) {
	    	
			percentageField.sendKeys(percentage);
		}
	    
        public void enterValueToAmountField(String amount) {
	    	
			amountField.sendKeys(amount);
		}
	     public void uploadOfferImage(String url)  {
		
				fileUploadUtility.fileUploadUsingSendKeys(chooseFile, url);
			
		}
	     
	     public boolean isAlertVisible() {
	    	 
	    	 return alert.isDisplayed();
			
		}
	    
	    
}
