package testscript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageDeliveryBoyPage;
import pages.ManageProductPage;
import utilities.ExcelUtility;

public class ManageProductTest extends Base {

	@Test(retryAnalyzer =listerners.Retry.class,groups= {"Regression"} ,description ="Veryfy whether any product is featured out of first 20 products in the table")
	public void verifyAnyProductIsFeaturedInTheList() {
		
		ManageProductPage manageProductPage= new ManageProductPage(driver);
		LoginPage loginPage = new LoginPage(driver);
	    loginPage.login();
	    loginPage.navigateToAPage(ExcelUtility.getString(4, 1, "url"));
        
        boolean isAnyProductFeatured=manageProductPage.checkProductIsFeatured();
        
        assertTrue(isAnyProductFeatured, "Couldn't detect any product as featured");		
	}
}
