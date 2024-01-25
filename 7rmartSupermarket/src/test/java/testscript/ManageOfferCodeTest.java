package testscript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageOfferCodePage;
import utilities.ExcelUtility;
import utilities.GeneralUtility;

public class ManageOfferCodeTest extends Base{
@Test (description="verify whether new offer code is getting added when correct deatils are entered")
public void veryfyWhetherNewOfferCodeIsGettingAddedWhenCoorectDetailsAreEntered() {
	String username =ExcelUtility.getString(1, 0, "LoginPage");
	String password=ExcelUtility.getString(1, 1, "LoginPage");
	LoginPage loginPage = new LoginPage(driver);
    loginPage.enterUserNameOnUserNameField(username);
    loginPage.enterPassWordOnPassWordFeild(password);
    loginPage.clickOnSignInButton();
    loginPage.navigateToAPage(ExcelUtility.getString(3,1, "url"));
    
    
    
    ManageOfferCodePage manageOfferCodePage= new ManageOfferCodePage(driver);
    manageOfferCodePage.clickOnNewButton();
    manageOfferCodePage.enterValueToNewOfferCode();
    manageOfferCodePage.clickOnRadioButtonYes();
    manageOfferCodePage.enterValueToPercentageField(ExcelUtility.getInteger(1, 0, "ManageOfferCodePage"));
    manageOfferCodePage.enterValueToAmountField(ExcelUtility.getInteger(1, 1, "ManageOfferCodePage"));
    manageOfferCodePage.uploadOfferImage(GeneralUtility.OFFERIMAGE);
    manageOfferCodePage.clickOnSaveButton();
    
    boolean isOfferCodeCreated =manageOfferCodePage.isAlertVisible();
    assertTrue(isOfferCodeCreated,"New Offer code not cretaed when correct details entered");
    
    
    
}
	    
}
