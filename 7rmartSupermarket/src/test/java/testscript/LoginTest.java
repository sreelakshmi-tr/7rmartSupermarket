package testscript;



import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
    
	@Test(description="verify whether the user is able to log in with correct username and correct password")
	public void verifyWhetherTheUserIsAbleToLoginWithValidCredentials() {
		String username =ExcelUtility.getString(1, 0, "LoginPage");
		String password=ExcelUtility.getString(1, 1, "LoginPage");
		
		LoginPage loginPage = new LoginPage(driver);
	    loginPage.enterUserNameOnUserNameField(username);
	    loginPage.enterPassWordOnPassWordFeild(password);
	    loginPage.clickOnSignInButton();
		
        boolean isHomePageLoaded=loginPage.isDashBoardLoaded();
		
      assertTrue(isHomePageLoaded, "Home page not loaded when user is entering valid credentials");

	}
	
	@Test(description="verify whether the user is unable to log in with incorrect username and correct password")
	public void verifyWhetherTheUserIsUnbleToLoginWithIncorrectUserNameAndCorrectPassWord() {
		String username =ExcelUtility.getString(3, 0, "LoginPage");
		String password=ExcelUtility.getString(3, 1, "LoginPage");
		
		LoginPage loginPage = new LoginPage(driver);
	    loginPage.enterUserNameOnUserNameField(username);
	    loginPage.enterPassWordOnPassWordFeild(password);
	    loginPage.clickOnSignInButton();
		
        boolean isAlertShowedUp =loginPage.isAlertVisible();
		
      assertTrue(isAlertShowedUp, "Home page is loaded with incorrect username");

	}
	
	@Test(description="verify whether the user is unable to log in with correct username and incorrect password")
	public void verifyWhetherTheUserIsUnableToLoginWithCorrectUserNameAndIncorrectPassWord() {
		String username =ExcelUtility.getString(2, 0, "LoginPage");
		String password=ExcelUtility.getString(2, 1, "LoginPage");
		
		LoginPage loginPage = new LoginPage(driver);
	    loginPage.enterUserNameOnUserNameField(username);
	    loginPage.enterPassWordOnPassWordFeild(password);
	    loginPage.clickOnSignInButton();
		
        boolean isAlertShowedUp =loginPage.isAlertVisible();
		
      assertTrue(isAlertShowedUp, "Home page is loaded with incorrect password");

	}
	
	@Test(dataProvider = "LoginProvider" ,description="verify whether the user is unable to log in with incorrect username and incorrect password")
	public void verifyWhetherTheUserIsUnableToLoginWithIncorrectUserNameAndIncorrectPassWord(String username,String password) {
		
		LoginPage loginPage = new LoginPage(driver);
	    loginPage.enterUserNameOnUserNameField(username);
	    loginPage.enterPassWordOnPassWordFeild(password);
	    loginPage.clickOnSignInButton();
		
        boolean isAlertShowedUp =loginPage.isAlertVisible();
		
        assertTrue(isAlertShowedUp, "Home page is loaded with invalid credentials");
      
	}
	
	@DataProvider(name="LoginProvider")
	public Object[][] getDataFromTestData(){
		return new Object[][] {{ExcelUtility.getString(4, 0, "LoginPage"),ExcelUtility.getString(4, 1, "LoginPage")}};
		
	}
}
