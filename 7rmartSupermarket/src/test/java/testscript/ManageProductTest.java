package testscript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageDeliveryBoyPage;
import pages.ManageProductPage;
import utilities.ExcelUtility;

public class ManageProductTest extends Base {

	@Test(description ="Veryfy whether any product is featured out of first 20 products in the table")
	public void verifyAnyProductIsFeaturedInTheList() {
		
		ManageProductPage manageProductPage= new ManageProductPage(driver);
		String username =ExcelUtility.getString(1, 0, "LoginPage");
		String password=ExcelUtility.getString(1, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
	    loginPage.enterUserNameOnUserNameField(username);
	    loginPage.enterPassWordOnPassWordFeild(password);
	    loginPage.clickOnSignInButton();
        loginPage.navigateToAPage(ExcelUtility.getString(4, 1, "url"));
        
        boolean isAnyProductFeatured=manageProductPage.checkProductIsFeatured();
        
        assertTrue(isAnyProductFeatured, "Couldn't detect any product as featured");		
	}
}
