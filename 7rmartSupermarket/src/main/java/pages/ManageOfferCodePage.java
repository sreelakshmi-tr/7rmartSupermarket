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
	    @FindBy(xpath = "//a[@onclick='click_button(1)']")WebElement newButton;
	    @FindBy(xpath = "//input[@id='offer_code']")WebElement offerCodeField;
	    @FindBy(xpath = "//input[@value='yes']")WebElement radioButtonYes;
	    @FindBy(xpath = "//input[@placeholder='Percentage']")WebElement percentageField;
	    @FindBy(xpath = "//input[@placeholder='Amount']")WebElement amountField;
	    @FindBy(xpath = "//div[@role='textbox']")WebElement descriptionField;
        @FindBy(xpath = "//input[@id='main_img']")WebElement chooseFile;
        @FindBy(xpath = "//button[@name='create']")WebElement saveButton;

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
			pageUtility.elementClick(driver, newButton);
		}
	    
	    public void enterValueToNewOfferCode() {
	    	
	    	offerCodeField.sendKeys(randomInputUtility.randomPasswordGenerator());
		}
	    
	    public void clickOnRadioButtonYes() {
			pageUtility.elementClick(driver, radioButtonYes);
		}
	    
	    public void clickOnSaveButton() {
	    	pageUtility.elementClick(driver, saveButton);
			
		}
	    public void enterValueToPercentageField(String percentage) {
	    	
			percentageField.sendKeys(percentage);
		}
	    
        public void enterValueToAmountField(String amount) {
	    	
			amountField.sendKeys(amount);
		}
	     public void uploadOfferImage(String url)  {
			try {
				fileUploadUtility.fileUploadUsingRobotClass(chooseFile, url);
			} catch (AWTException e) {
				e.printStackTrace();
			}
		}
	    
	    
}