package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

import utilities.PageUtility;

public class ManageProductPage {
	
	WebDriver driver;
	PageUtility pageUtility;
	
	
	@FindAll({@FindBy(xpath = "//table//tbody//td[8]//span") })private List<WebElement> featuredButton;
	
	public ManageProductPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this );
        pageUtility = new PageUtility();
		}
	
	public boolean checkProductIsFeatured() {
		for(WebElement element:featuredButton) {
			if(element.getText().equals("Yes")) {
				return true;
			}
		}
		
		return false;
	}
}
