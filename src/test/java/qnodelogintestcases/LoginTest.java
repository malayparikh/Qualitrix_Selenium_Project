package qnodelogintestcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qnode.qa.pages.AccountPage;
import com.qnode.qa.pages.HomePage;
import com.qnode.qa.pages.LoginPage;
import com.qnodetestingproject.base.Base;
import com.qnodetestingproject.util.Utilities;



public class LoginTest extends Base {
	
	LoginPage loginPage;
	AccountPage accountPage;
	
	public LoginTest() {
		super();
	}
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
		
		HomePage homePage = new HomePage(driver);
		
		homePage.clickOnMyAccount();
		//homePage.selectLoginOption();  // New Change
		
		 loginPage = homePage.selectLoginOption();
		
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
		
	}
	
	@Test(priority=1, dataProvider = "validCredentialSuppy" )
	public void verifyLoginWithValidCredentials(String email, String password) {
		
		//LoginPage loginPage = new LoginPage(driver);  New Change
		//AccountPage accountPage = new AccountPage(driver);
		
	
		loginPage.enterEmailAddress(email);
		loginPage.enterPassword(password);
		accountPage=loginPage.clickOnLoginButton();
		
		Assert.assertTrue(accountPage.getDisplayStatusOfEditYourAccountInformation());
	
				
	}
	@DataProvider(name="validCredentialSuppy")
	public Object[][] supplyTestData() {
		
		//Object [][] data = {{"demousermalay@gmail.com", "12345"},{"demouser1@gmail1.com","12345"}};
		Object [][] data = Utilities.getTestDataFromExcel("Login");
		return data;
		
		
	}
	
	
		
	
	@Test(priority=2)
	public void verifyLoginWithInvalidCredentials() {
		
		//LoginPage loginPage = new LoginPage(driver); 
		
		loginPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		loginPage.enterPassword("1234567");
		loginPage.clickOnLoginButton();
		String actualWarningMessage = loginPage.retriveEmailPasswordNotMatchingWarningMessage();
		String expectedWarningMesssage="Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMesssage),"Fail");
				
	}
	
	@Test(priority=3)
	public void verifyLoginWithInvalidEmailAndValidPassword() {
		
		//LoginPage loginPage = new LoginPage(driver);
		
		
		loginPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		loginPage.enterPassword(prop.getProperty("validPassword"));
		loginPage.clickOnLoginButton();
		String actualWarningMessage = loginPage.retriveEmailPasswordNotMatchingWarningMessage();
		String expectedWarningMesssage="Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMesssage),"Fail");
		
		
		
		
	}
	@Test(priority=4)
	public void verifyLoginWithValidEmailAndInvalidPassword() {
		
		//LoginPage loginPage = new LoginPage(driver);
		
		
		loginPage.enterEmailAddress(prop.getProperty("validEmail"));
		loginPage.enterPassword("123456789");
		loginPage.clickOnLoginButton();
		String actualWarningMessage = loginPage.retriveEmailPasswordNotMatchingWarningMessage();
		String expectedWarningMesssage="Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMesssage),"Fail");
				
	}
	
	@Test(priority=5)
	public void verifyLoginWithoutCredentials() {
		
		//LoginPage loginPage = new LoginPage(driver);
		
		loginPage.clickOnLoginButton();
		String actualWarningMessage = loginPage.retriveEmailPasswordNotMatchingWarningMessage();
		String expectedWarningMesssage="Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMesssage),"Fail");
		
		Assert.assertTrue(false);
			
		
	}
	

	
	
}
