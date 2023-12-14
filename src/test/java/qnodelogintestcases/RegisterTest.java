package qnodelogintestcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qnode.qa.pages.AccountSuccessPage;
import com.qnode.qa.pages.HomePage;
import com.qnode.qa.pages.RegisterPage;
import com.qnodetestingproject.base.Base;
import com.qnodetestingproject.util.Utilities;

public class RegisterTest extends Base {
	
	RegisterPage registerPage;

	public RegisterTest() {

		super();
	}

	WebDriver driver;

	@BeforeMethod
	public void setUp() {

		driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
		HomePage homePage = new HomePage(driver);

		homePage.clickOnMyAccount();
		registerPage = homePage.selectRegisterOption();

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();

	}

	@Test(priority = 1)
	public void verifyRegisterWithMandatoryFields()

	{

		//RegisterPage registerPage = new RegisterPage(driver);

		registerPage.enterFirstNameText("demouser22");
		registerPage.enterLastNameText("demolastname");
		registerPage.emailAddressText(Utilities.generateEmailWithTimeStamp());
		registerPage.telephoneText("9999955555");
		registerPage.passwordText("123456");
		registerPage.passwordConfirmText("123456");
		registerPage.clickOnPrivacyPolicy();
		registerPage.clickOnContinueButton();

		AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);

		String actualMessage = accountSuccessPage.retriveAccountSuccessPageHeading();

		Assert.assertEquals(actualMessage, "Your Account Has Been Created!", "Account not created");

	}

	@Test(priority = 2)
	public void verifyRegisterWithAllFields() {

		//RegisterPage registerPage = new RegisterPage(driver);

		registerPage.enterFirstNameText("demouser22");
		registerPage.enterLastNameText("demolastname");
		registerPage.emailAddressText(Utilities.generateEmailWithTimeStamp());
		registerPage.telephoneText("9999955555");
		registerPage.passwordText("123456");
		registerPage.passwordConfirmText("123456");
		registerPage.selectYesNewsletterOption();
		registerPage.clickOnPrivacyPolicy();
		registerPage.clickOnContinueButton();

		AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
		String actualMessage = accountSuccessPage.retriveAccountSuccessPageHeading();
		Assert.assertEquals(actualMessage, "Your Account Has Been Created!", "Account not created");

	}

	@Test(priority = 3)
	public void verifyRegisterAccountWithExistingEmail() {

		//RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstNameText("John");
		registerPage.enterLastNameText("Paul");
		registerPage.emailAddressText("demousermalay@gmail.com");
		registerPage.telephoneText("9999955555");
		registerPage.passwordText(prop.getProperty("validPassword"));
		registerPage.passwordConfirmText(prop.getProperty("validPassword"));
		registerPage.selectYesNewsletterOption();
		registerPage.clickOnPrivacyPolicy();
		registerPage.clickOnContinueButton();

		String actualWarningMessage = registerPage.retriveDuplicateEmailAddressWarning();
		Assert.assertEquals(actualWarningMessage, "Warning: E-Mail Address is already registered!");

	}

	@Test(priority = 4)
	public void verifyRegisterAccountWithoutProvidingDetails() {

		//RegisterPage registerPage = new RegisterPage(driver);
		registerPage.clickOnContinueButton();

		String actualPrivacyWarning = registerPage.retrivePrivacyPolicyWarning();
		String expectedPrivacyWarning = "Warning: You must agree to the Privacy Policy!";
		Assert.assertEquals(actualPrivacyWarning, expectedPrivacyWarning);

		String actualFnameWarning = registerPage.retriveFirstNameWarning();
		String expectedFnameWarning = "First Name must be between 1 and 32 characters!";
		Assert.assertEquals(actualFnameWarning, expectedFnameWarning);

		String actualLnameWarning = registerPage.retriveLastNameWarning();
		String expectedLnameWarning = "Last Name must be between 1 and 32 characters!";
		Assert.assertEquals(actualLnameWarning, expectedLnameWarning);

		String actualPhoneWarning = registerPage.retriveTelephoneWarning();
		String expectedPhoneWarning = "Telephone must be between 3 and 32 characters!";
		Assert.assertEquals(actualPhoneWarning, expectedPhoneWarning);

		String actualPasswordWarning = registerPage.retrivePasswordWarning();
		String expectedPasswordWarning = "Password must be between 4 and 20 characters!";
		Assert.assertEquals(actualPasswordWarning, expectedPasswordWarning);

	}

}
