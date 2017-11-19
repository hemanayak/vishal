package com.clusters.test.config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.clusters.utils.DataHandler;

public class TestConfiguration 
{
	public static WebDriver createDriverInstance()
	{
		String browser = DataHandler.getDataFromPropery("configuration", "browser");
		String url = DataHandler.getDataFromPropery("configuration", "url");
		String app_url=null;
		WebDriver driver = null;
		if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.firefox.marionette", 
					"./browser-server/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", 
					"./browser-server/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else
		{
			System.err.println("Invalid browser option");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if(url.equals("release"))
		{
			app_url = DataHandler.getDataFromPropery("configuration", "release");
		}
		else if(url.equals("develop"))
		{
			app_url = DataHandler.getDataFromPropery("configuration", "develop");
		}
		driver.get(app_url);
		return driver;
	}
}
