package testscript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.ManageOfferCodePage;
import utilities.ExcelUtility;

public class ManageOfferCodeTest extends Base{
@Test(retryAnalyzer =listerners.Retry.class,groups= {"Regression"} ,description="verify whether new offer code is getting added when correct deatils are entered")
public void veryfyWhetherNewOfferCodeIsGettingAddedWhenCoorectDetailsAreEntered() {
	LoginPage loginPage = new LoginPage(driver);
    loginPage.login();
    loginPage.navigateToAPage(ExcelUtility.getString(3,1, "url"));   
    
    ManageOfferCodePage manageOfferCodePage= new ManageOfferCodePage(driver);
    manageOfferCodePage.clickOnNewButton();
    manageOfferCodePage.enterValueToNewOfferCode();
    manageOfferCodePage.clickOnRadioButtonYes();
    manageOfferCodePage.enterValueToPercentageField(ExcelUtility.getInteger(1, 0, "ManageOfferCodePage"));
    manageOfferCodePage.enterValueToAmountField(ExcelUtility.getInteger(1, 1, "ManageOfferCodePage"));
    manageOfferCodePage.uploadOfferImage(Constants.OFFERIMAGE);
    manageOfferCodePage.clickOnSaveButton();
    
    boolean isOfferCodeCreated =manageOfferCodePage.isAlertVisible();
    assertTrue(isOfferCodeCreated,"New Offer code not cretaed when correct details entered");
    
    
    
}
	    
}
