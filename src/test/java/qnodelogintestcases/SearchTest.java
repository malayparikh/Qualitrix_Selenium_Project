package qnodelogintestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qnode.qa.pages.HomePage;
import com.qnode.qa.pages.SearchPage;
import com.qnodetestingproject.base.Base;

public class SearchTest extends Base {
	

	public SearchTest() {
		super();
	}
	
WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName"));

		
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
		
	}
	
	@Test(priority=1)
	public void verifySearchWithValidProduct() {
		
		
		HomePage homePage = new HomePage(driver);
		SearchPage searchPage = new SearchPage(driver);
		homePage.enterProductIntoSearhBoxField("HP");
		homePage.clickOnSearchButton();
		
		Assert.assertTrue(searchPage.displayStatusOfHPValidProduct());
		
	}
	@Test(priority=2)
	public void verifySearchWithNonExistProduct() {
		
		HomePage homePage = new HomePage(driver);
		SearchPage searchPage = new SearchPage(driver);
		homePage.enterProductIntoSearhBoxField("Honda");
		homePage.clickOnSearchButton();
		
		String actualSearchMessage = searchPage.retriveNoProductMessageText();
		Assert.assertEquals(actualSearchMessage, "There is no product that matches the search criteria.");
	}
	
	@Test(priority=3)
	public void verifySearchWihoutProduct() {
		
		HomePage homePage = new HomePage(driver);
		SearchPage searchPage = new SearchPage(driver);
		homePage.enterProductIntoSearhBoxField(" ");
		homePage.clickOnSearchButton();
		
		String actualSearchMessage = searchPage.retriveNoProductMessageText();
		Assert.assertEquals(actualSearchMessage, "There is no product that matches the search criteria.");
	}

}
