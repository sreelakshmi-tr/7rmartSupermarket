package testscript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MobileSliderPage;
import utilities.ExcelUtility;

public class MobileSliderTest extends Base{
	

	@Test(retryAnalyzer =retry.Retry.class,groups= {"Regression"} ,description="Verify whether the Mobile slider page heading is correct")
	public void verifyWhetherMobleSliderPageHeadingIsCorrect() {
		
		String username =ExcelUtility.getString(1, 0, "LoginPage");
		String password=ExcelUtility.getString(1, 1, "LoginPage");
		MobileSliderPage mobileSliderPage = new MobileSliderPage(driver);

				
		
		LoginPage loginPage = new LoginPage(driver);
	    loginPage.enterUserNameOnUserNameField(username);
	    loginPage.enterPassWordOnPassWordFeild(password);
	    loginPage.clickOnSignInButton();
        loginPage.navigateToAPage(ExcelUtility.getString(5,1, "url"));
        
		String expectedHeading=ExcelUtility.getString(0, 1, "MobileSliderPage");
		
		boolean isHeadingMatching=mobileSliderPage.headingIsCorrectOrNot(expectedHeading);

        assertTrue(isHeadingMatching);
        
        
	}     
     
}
