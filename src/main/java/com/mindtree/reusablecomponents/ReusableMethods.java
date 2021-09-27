package com.mindtree.reusablecomponents;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.mindtree.utility.PropertyFileReader;

public class ReusableMethods {

	public static void loadURL(WebDriver driver) throws IOException {
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
		timelapse(driver);
	}
	
	public static void timelapse(WebDriver driver) throws NumberFormatException, IOException {
		int wait = Integer.parseInt(PropertyFileReader.loadFile().getProperty("implicitWait"));
		driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
	}
	
	public static boolean getElement(By selector, WebDriver driver) {
		try {
			driver.findElement(selector);
			return true;
		}
		catch(Exception e) {
			System.out.println(String.format("Element %s doesnt exist", selector));
		}
		return false;
	}
	
	public static boolean sendKeys(By selector, String keys, WebDriver driver) {
		try {
			driver.findElement(selector).sendKeys(keys);;
			return true;
		}
		catch(Exception e) {
			System.out.println(String.format("Keys could not be sent to Element %s ", selector));
		}
		return false;
	}
	
	public static boolean hover(By selector,WebDriver driver) {
		try {
			WebElement prod = driver.findElement(selector);
			Actions action = new Actions(driver);
			action.moveToElement(prod).click().build().perform();
			return true;
		}
		catch(Exception e) {
				System.out.println(String.format("Element %s could not be hovered ", selector));
		}
		return false;
	}
	
	public static boolean click(By selector, WebDriver driver) {
		try {
			driver.findElement(selector).click();;
			return true;
		}
		catch(Exception e) {
			System.out.println(String.format("Element %s could not be clicked ", selector));
		}
		return false;
	}
	
	public static String getText(By selector, WebDriver driver) {
		try {
			return driver.findElement(selector).getText();
		}
		catch(Exception e) {
			System.out.println(String.format("Element %s could not be clicked ", selector));
		}
		return null;
	}
	public static List<WebElement> getElements(By selector,WebDriver driver){
		try {
			return driver.findElements(selector);
		}
		catch(Exception e) {
			System.out.println(String.format("Element %s could not be clicked ", selector));
		}
		return null;
	}
}
