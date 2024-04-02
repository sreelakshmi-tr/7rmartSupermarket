package testscript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageOrderPage;
import utilities.ExcelUtility;

public class ManageOrderTest extends Base {
    
	@Test(retryAnalyzer =retry.Retry.class,groups= {"Regression"} ,description="Veryfing able to see the details of an existing order number")
	public void verifyIsOrderDetailsViewableForAnExistingOrderID() {
		
		
		String orderID=ExcelUtility.getInteger(1, 0, "ManageOrderPage");
		LoginPage loginPage = new LoginPage(driver);
	    loginPage.login();
        loginPage.navigateToAPage(ExcelUtility.getString(2,1, "url"));
		
        ManageOrderPage manageOrderPage=new ManageOrderPage(driver);
        manageOrderPage.clickOnSearchButton();
        manageOrderPage.enterOrderIdOnOrderIdInputField(orderID);
        manageOrderPage.clickOnSearchSubmitButton();
        manageOrderPage.clickOnViewButton();
        boolean isOderDetailsPageOpen= manageOrderPage.isPrintButtonVisible();
        assertTrue(isOderDetailsPageOpen, "Order details not loading/ displayed for valid order id");
	}
}
