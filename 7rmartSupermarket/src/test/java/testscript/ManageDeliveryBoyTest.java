package testscript;
import pages.LoginPage;
import  pages.ManageDeliveryBoyPage;
import utilities.ExcelUtility;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class ManageDeliveryBoyTest extends Base{
	
	@Test(retryAnalyzer =listerners.Retry.class,groups= {"Regression"} ,description="Veryfy whether Delevery boy details is getting deleted on delete button click")
	public void verifyIsFirstRowOfDeliveryBoyIsDeletedByDeleteButtonClick() {
		ManageDeliveryBoyPage manageDeliveryBoyPage= new ManageDeliveryBoyPage(driver);
		LoginPage loginPage = new LoginPage(driver);
	    loginPage.login();
        loginPage.navigateToAPage(ExcelUtility.getString(1, 1, "url"));
		
		manageDeliveryBoyPage.deleteFirstRow();
		manageDeliveryBoyPage.confirmDelete();
		
		boolean isDeleveryBoyDeleted = manageDeliveryBoyPage.isDeliveryBoyDeleted();
		
		assertTrue(isDeleveryBoyDeleted,"Delevery boy details didn't deleted on delete button click");
	}
	
	@Test(retryAnalyzer =listerners.Retry.class,groups= {"Regression"} ,description="Verify whether no new delivery boy is getting added if the mandatory fields missing")
	public void verifyNoNewDeliverBoyIsGettingCreatedIfMandatoryFieldsAreMissing() {
		

		ManageDeliveryBoyPage manageDeliveryBoyPage= new ManageDeliveryBoyPage(driver);
		LoginPage loginPage = new LoginPage(driver);
	    loginPage.login();
        loginPage.navigateToAPage(ExcelUtility.getString(1, 1, "url"));
       
		manageDeliveryBoyPage.clickOnNewButton();
        manageDeliveryBoyPage.enterNewNameOnTheForm();

        manageDeliveryBoyPage.clickOnSaveButton();
        
        boolean isNewUserNotCreated= manageDeliveryBoyPage.isNewUserNameFieldEmplty();
        
        assertTrue(isNewUserNotCreated,"New Delivery boy got created without all mandatory fields filled");
		
	}
	
	@Test(retryAnalyzer =listerners.Retry.class,description="Verify whether no delivery boy is present in the list for an invalid email id")
	public void verifyNoDeliverBoyPresntInTheListForAnInValidEmail() {
		
		
		String email =ExcelUtility.getString(1, 1, "ManageDeliveryBoyPage");
		ManageDeliveryBoyPage manageDeliveryBoyPage= new ManageDeliveryBoyPage(driver);
		LoginPage loginPage = new LoginPage(driver);
	    loginPage.login();
        loginPage.navigateToAPage(ExcelUtility.getString(1, 1, "url"));
        manageDeliveryBoyPage.clickOnsearchMenuButton();
        manageDeliveryBoyPage.enterEmailOnEmailField(email);
        manageDeliveryBoyPage.clickOnSearchSubmitButton();
        
        boolean isNoResult= manageDeliveryBoyPage.isResultNotFoundMessageVisible();
        
        assertTrue(isNoResult,"Delivery boy details shown for invalid email id");
		
	}
	
	@Test(retryAnalyzer =listerners.Retry.class,groups= {"Regression"} ,description="Verify whether any delivery boy is present in the list for a valid email id")
    public void verifyAnyDeliverBoyPresentInTheListForAValidEmail() {
		
		
		String email =ExcelUtility.getString(2, 1, "ManageDeliveryBoyPage");
		ManageDeliveryBoyPage manageDeliveryBoyPage= new ManageDeliveryBoyPage(driver);
		LoginPage loginPage = new LoginPage(driver);
	    loginPage.login();
        loginPage.navigateToAPage(ExcelUtility.getString(1, 1, "url"));
       
        manageDeliveryBoyPage.clickOnsearchMenuButton();
        manageDeliveryBoyPage.enterEmailOnEmailField(email);
        manageDeliveryBoyPage.clickOnSearchSubmitButton();
        
        boolean isResultPresent= manageDeliveryBoyPage.isResultAvailable();
        
        assertTrue(isResultPresent,"No delivery boy details shown for a valid email id");
		
	}

	@Test(retryAnalyzer =listerners.Retry.class,description="Verify whether no delivery boy is present in the list for an invalid name")
	public void verifyNoDeliverBoyPresntInTheListForAnInValidName() {
		
		
		String name =ExcelUtility.getString(4, 0, "ManageDeliveryBoyPage");
		ManageDeliveryBoyPage manageDeliveryBoyPage= new ManageDeliveryBoyPage(driver);
		LoginPage loginPage = new LoginPage(driver);
	    loginPage.login();
        loginPage.navigateToAPage(ExcelUtility.getString(1, 1, "url"));
       
		
        manageDeliveryBoyPage.clickOnsearchMenuButton();
        manageDeliveryBoyPage.enterNameOnNameField(name);;
        manageDeliveryBoyPage.clickOnSearchSubmitButton();
        
        boolean isNoResult= manageDeliveryBoyPage.isResultNotFoundMessageVisible();
        
        assertTrue(isNoResult,"Delivery boy details shown for invalid name");
		
	}
	
	@Test(retryAnalyzer =listerners.Retry.class,description="Verify whether any delivery boy is present in the list for a valid name")
    public void verifyAnyDeliverBoyPresentInTheListForAValidName() {
		
		
		String name =ExcelUtility.getString(5, 0, "ManageDeliveryBoyPage");
		ManageDeliveryBoyPage manageDeliveryBoyPage= new ManageDeliveryBoyPage(driver);
		LoginPage loginPage = new LoginPage(driver);
	    loginPage.login();
        loginPage.navigateToAPage(ExcelUtility.getString(1, 1, "url"));
       
		
        manageDeliveryBoyPage.clickOnsearchMenuButton();
        manageDeliveryBoyPage.enterNameOnNameField(name);
        manageDeliveryBoyPage.clickOnSearchSubmitButton();
        
        boolean isResultPresent= manageDeliveryBoyPage.isResultAvailable();
        
        assertTrue(isResultPresent,"No delivery boy details shown for a valid name");
		
	}
	

	@Test(retryAnalyzer =listerners.Retry.class,description="Verify whether the delivery boy is not available in the list with invalid phone number")
	public void verifyNoDeliverBoyPresntInTheListForAnInValidPhoneNumber() {
		
		
		String phoneNumber =null;
		ManageDeliveryBoyPage manageDeliveryBoyPage= new ManageDeliveryBoyPage(driver);
		LoginPage loginPage = new LoginPage(driver);
	    loginPage.login();
        loginPage.navigateToAPage(ExcelUtility.getString(1, 1, "url"));
       
		
        manageDeliveryBoyPage.clickOnsearchMenuButton();
        manageDeliveryBoyPage.enterPhoneNumberOnPhoneNumberField(phoneNumber);
        manageDeliveryBoyPage.clickOnSearchSubmitButton();
        
        boolean isNoResult= manageDeliveryBoyPage.isResultNotFoundMessageVisible();
        
        assertTrue(isNoResult,"Delivery boy details shown for invalid name");
		
	}
	
	@Test(retryAnalyzer =listerners.Retry.class,description="Verify whether the delivery boy is  available in the list for valid phone number")
    public void verifyAnyDeliverBoyPresentInTheListForAValidePhoneNumber() {
		
		
		String phoneNumber =ExcelUtility.getInteger(3, 2, "ManageDeliveryBoyPage");
		ManageDeliveryBoyPage manageDeliveryBoyPage= new ManageDeliveryBoyPage(driver);
		LoginPage loginPage = new LoginPage(driver);
	    loginPage.login();
        loginPage.navigateToAPage(ExcelUtility.getString(1, 1, "url"));
       
		
        manageDeliveryBoyPage.clickOnsearchMenuButton();
        manageDeliveryBoyPage.enterPhoneNumberOnPhoneNumberField(phoneNumber);;
        manageDeliveryBoyPage.clickOnSearchSubmitButton();
        
        boolean isResultPresent= manageDeliveryBoyPage.isResultAvailable();
        
        assertTrue(isResultPresent,"No delivery boy details shown for a valid phone number");
		
	}
	
	@Test(retryAnalyzer =listerners.Retry.class,groups= {"Regression"} ,description="Verify whether the delivery boy status is getting changed by the status button click")
    public void verifyDeliverBoyStatusGettingChangedByStatusButtonClick() {
		
		
		ManageDeliveryBoyPage manageDeliveryBoyPage= new ManageDeliveryBoyPage(driver);
		LoginPage loginPage = new LoginPage(driver);
	    loginPage.login();
        loginPage.navigateToAPage(ExcelUtility.getString(1, 1, "url"));
       
		String oldStatus= manageDeliveryBoyPage.currentStatus();

        manageDeliveryBoyPage.clickOnStatusButton();
        
		String newStatus= manageDeliveryBoyPage.currentStatus();


        assertNotEquals(oldStatus, newStatus,"Delivery boy status didn't change by click on status button");
		
	}
}
