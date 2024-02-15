package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class MobileSliderPage {
	    WebDriver driver;
	    PageUtility pageUtility;
	    
	    @FindBy(xpath = "//div[@class='container-fluid']//h1")private WebElement heading;
	    
	    public MobileSliderPage(WebDriver driver) {
			this.driver =driver;
			PageFactory.initElements(driver,this );
	        pageUtility = new PageUtility();
		}
	    
	   
	    
	    public boolean headingIsCorrectOrNot(String expectedHeading) {
	    	 
	    	 return pageUtility.getElementText(heading).equals(expectedHeading);
			
		}
		
}
