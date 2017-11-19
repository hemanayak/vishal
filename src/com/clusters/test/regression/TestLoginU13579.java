package com.clusters.test.regression;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.clusters.repo.ui.LoginPage;
import com.clusters.test.config.TestConfiguration;

public class TestLoginU13579 
{
	WebDriver driver;
	LoginPage login_page;
	@BeforeMethod
	public void setUp()
	{
		driver = TestConfiguration.createDriverInstance();
		login_page = new LoginPage(driver);
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	@Test
	public void testLoginInvalidTC583()
	{
		login_page.waitForLoginPageTOLoad();
		// Enter Invaild UN
		login_page.getUsernameTextbox().sendKeys("Invaild");
//		 Enter Invaild password
		login_page.getPasswordTextbox().sendKeys("Invaild");
		// Click on Login button
		login_page.getLoginButton().click();
		//Get error msg
		String actualErrMsg = login_page.getLoginErrorMsg().getText();
		String expectedErrMsg = "Username or Password is invalid. Please try again.";
		// Check error msg
		Assert.assertEquals(actualErrMsg, expectedErrMsg);
	}
}






