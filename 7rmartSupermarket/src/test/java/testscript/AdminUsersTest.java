package testscript;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUsersTest extends Base {
	
	
    @Test(description="Verify whether new user is getting added when entering corrrect details ")
	public void verifyWhetherAnUserSuccessfullyGetAddedWhenEnteringCorrectDetails() {
		
		String username =ExcelUtility.getString(1, 0, "LoginPage");
		String password=ExcelUtility.getString(1, 1, "LoginPage");
        AdminUsersPage adminUsersPage = new AdminUsersPage(driver);

		String newUserName=adminUsersPage.getNewUserName();
		String newPassWord=adminUsersPage.getNewPassword();
		String newUserType=ExcelUtility.getString(1, 2, "AdminUsersPage");
				
		
		LoginPage loginPage = new LoginPage(driver);
	    loginPage.enterUserNameOnUserNameField(username);
	    loginPage.enterPassWordOnPassWordFeild(password);
	    loginPage.clickOnSignInButton();
        loginPage.navigateToAPage("https://groceryapp.uniqassosiates.com/admin/list-admin");
       
        
        adminUsersPage.clickOnNewButton();
        adminUsersPage.enterUserNameOnUserNameField(newUserName);
        adminUsersPage.enterPassWordOnPassWordField(newPassWord);
        adminUsersPage.selectUserType(newUserType);
        adminUsersPage.clickOnSaveButton();
        
        boolean isNewUserCreatedSucessfully=adminUsersPage.isSuccessAlertVisible();
        assertTrue(isNewUserCreatedSucessfully, "No new user created with correct details entered ");
	}
}
