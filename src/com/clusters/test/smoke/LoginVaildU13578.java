package com.clusters.test.smoke;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.clusters.repo.ui.HomePage;
import com.clusters.repo.ui.LoginPage;
import com.clusters.test.config.TestConfiguration;
import com.clusters.utils.DataHandler;

public class LoginVaildU13578
{
	WebDriver driver;
	LoginPage login_page;
	HomePage home_page;
	
	@BeforeMethod
	public void setUp()
	{
		driver = TestConfiguration.createDriverInstance();
		login_page = new LoginPage(driver);
		home_page = new HomePage(driver);
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	@Test
	public void testLoginValidTC156()
	{
		// Reading data from Excel
		String un = 
				DataHandler.getDataFromExcel("data", "TC156", 1, 0);
		String pwd = 
				DataHandler.getDataFromExcel("data", "TC156", 1, 1);
		// Wait for Login page
		login_page.waitForLoginPageTOLoad();
		// Enter valid UN
		login_page.getUsernameTextbox().sendKeys(un);
		// Enter valid PWD
		login_page.getPasswordTextbox().sendKeys(pwd);
		// Click on Login button
		login_page.getLoginButton().click();
		//Verify home page
		boolean actual_status = 
				home_page.getLogoutButton().isDisplayed();
		Assert.assertEquals(actual_status, true);
		home_page.getLogoutButton().click();
	}
	
	
	
	
	
	
	
}
