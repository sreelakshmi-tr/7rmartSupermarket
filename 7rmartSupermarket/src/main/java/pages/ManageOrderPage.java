package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;


public class ManageOrderPage {
	WebDriver driver;
	PageUtility pageUtility;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")WebElement searchButton;
	@FindBy(xpath = "//input[@placeholder='Order Id']")WebElement orderIdInputField;
	@FindBy(xpath = "//button[@type='submit' and @name='Search']")WebElement searchSubmitButton;
	@FindBy(xpath = "//table//tbody//td[1]")WebElement searchResultOrderID;
	@FindBy(xpath = "//a[ contains(text(),'Assign')]")WebElement assignDeliveryBoyButton;
	@FindBy(xpath = "//a[ contains(text(),'View')]")WebElement viewButton;
	@FindBy(xpath = "//a[@onclick='javascript:window.print();']")WebElement printButton;

	public ManageOrderPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this );
		pageUtility = new PageUtility();
		}
	
	public void clickOnSearchButton() {
		pageUtility.elementClick(driver, searchButton);
	}
	
	public void clickOnSearchSubmitButton() {
		pageUtility.elementClick(driver, searchSubmitButton);
	}

	public void enterOrderIdOnOrderIdInputField(String orderID) {
		orderIdInputField.sendKeys(orderID);
	}
	
	public void clickOnAssignDeliveryBoyButton() {
		pageUtility.elementClick(driver, assignDeliveryBoyButton);
		
	}
	
	public void clickOnViewButton() {
		pageUtility.elementClick(driver, viewButton);
		
	}
	
	public void clickOnPrintButton() {
		pageUtility.elementClick(driver,printButton);
		
	}
	
	public boolean isPrintButtonVisible() {
		return printButton.isDisplayed();
	}
	
	
}
