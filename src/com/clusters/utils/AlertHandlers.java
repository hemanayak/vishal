package com.clusters.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertHandlers 
{
	public static void clickOKonAlert(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		alt.accept();
	}
	public static void clickCancelonAlert(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		alt.dismiss();
	}
	public static void enterTextonAlert(WebDriver driver, String text)
	{
		Alert alt = driver.switchTo().alert();
		alt.sendKeys(text);
	}
	public static String getAlertMessage(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		return alt.getText();
	}
}
