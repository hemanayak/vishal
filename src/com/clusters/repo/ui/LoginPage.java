package com.clusters.repo.ui;

import org.apache.regexp.recompile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage 
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public void waitForLoginPageTOLoad()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.
				visibilityOfAllElementsLocatedBy(By.name("LoginForm")));
	}
	public WebElement getUsernameTextbox()
	{
		return driver.findElement(By.name("username"));
	}
	public WebElement getPasswordTextbox()
	{
		return driver.findElement(By.name("pwd"));
	}
	public WebElement getLoginButton()
	{
		return driver.findElement(By.cssSelector("input[type='submit']"));
	}
	public WebElement getLoginErrorMsg()
	{
		return driver.findElement(By.xpath("//span[contains(text(), 'Username or P')]"));
	}
}
