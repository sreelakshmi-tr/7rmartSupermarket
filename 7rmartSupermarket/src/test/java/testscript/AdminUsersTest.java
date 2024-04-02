package testscript;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUsersTest extends Base {
	
	
    @Test(retryAnalyzer =retry.Retry.class,groups= {"Regression"} ,description="Verify whether new user is getting added when entering corrrect details ")
	public void verifyWhetherAnUserSuccessfullyGetAddedWhenEnteringCorrectDetails() {
		
		
        AdminUsersPage adminUsersPage = new AdminUsersPage(driver);
		String newUserName=adminUsersPage.getNewUserName();
		String newPassWord=adminUsersPage.getNewPassword();
		String newUserType=ExcelUtility.getString(1, 2, "AdminUsersPage");
				
		
		LoginPage loginPage = new LoginPage(driver);
	    loginPage.login();
        loginPage.navigateToAPage(ExcelUtility.getString(0,1, "url"));
       
        
        adminUsersPage.clickOnNewButton();
        adminUsersPage.enterUserNameOnUserNameField(newUserName);
        adminUsersPage.enterPassWordOnPassWordField(newPassWord);
        adminUsersPage.selectUserType(newUserType);
        adminUsersPage.clickOnSaveButton();
        
        boolean isNewUserCreatedSucessfully=adminUsersPage.isSuccessAlertVisible();
        assertTrue(isNewUserCreatedSucessfully, "No new user created with correct details entered ");
	}
}
