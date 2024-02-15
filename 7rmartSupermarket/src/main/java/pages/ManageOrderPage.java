package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;


public class ManageOrderPage {
	WebDriver driver;
	PageUtility pageUtility;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")private WebElement searchButton;
	@FindBy(xpath = "//input[@placeholder='Order Id']")private WebElement orderIdInputField;
	@FindBy(xpath = "//button[@type='submit' and @name='Search']")private WebElement searchSubmitButton;
	@FindBy(xpath = "//table//tbody//td[1]")private WebElement searchResultOrderID;
	@FindBy(xpath = "//a[ contains(text(),'Assign')]")private WebElement assignDeliveryBoyButton;
	@FindBy(xpath = "//a[ contains(text(),'View')]")private WebElement viewButton;
	@FindBy(xpath = "//a[@onclick='javascript:window.print();']")private WebElement printButton;

	public ManageOrderPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this );
		pageUtility = new PageUtility();
		}
	
	public void clickOnSearchButton() {
		pageUtility.elementClickUsingJavascriptExecutor(driver, searchButton);
	}
	
	public void clickOnSearchSubmitButton() {
		pageUtility.elementClickUsingJavascriptExecutor(driver, searchSubmitButton);
	}

	public void enterOrderIdOnOrderIdInputField(String orderID) {
		orderIdInputField.sendKeys(orderID);
	}
	
	public void clickOnAssignDeliveryBoyButton() {
		pageUtility.elementClickUsingJavascriptExecutor(driver, assignDeliveryBoyButton);
		
	}
	
	public void clickOnViewButton() {
		pageUtility.elementClickUsingJavascriptExecutor(driver, viewButton);
		
	}
	
	public void clickOnPrintButton() {
		pageUtility.elementClickUsingJavascriptExecutor(driver,printButton);
		
	}
	
	public boolean isPrintButtonVisible() {
		return printButton.isDisplayed();
	}
	
	
}
