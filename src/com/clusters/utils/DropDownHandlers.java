package com.clusters.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownHandlers 
{
	public static void selectDDLByIndex(WebElement ddl, int index)
	{
		Select sct = new Select(ddl);
		sct.selectByIndex(index);
	}
	public static void selectDDLByValue(WebElement ddl, String value)
	{
		Select sct = new Select(ddl);
		sct.selectByValue(value);
	}
	public static void selectDDLByVisibleText(WebElement ddl, String text)
	{
		Select sct = new Select(ddl);
		sct.selectByVisibleText(text);
	}
	public static void deselectDDLByIndex(WebElement ddl, int index)
	{
		Select sct = new Select(ddl);
		sct.deselectByIndex(index);
	}
	// Implement other 2 option
//	deselectDDLByValue(WebEelement ddl, String value)
//	deselectDDLByText(WebEelement ddl, String text)
	public static void deselectAllOptions(WebElement ddl)
	{
		Select sct = new  Select(ddl);
		sct.deselectAll();
	}
}
