package com.mindtree.runner;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.TestRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.mindtree.reusablecomponents.ReusableComponents;
import com.mindtree.reusablecomponents.ReusableMethods;
import com.mindtree.uistore.HomePageUI;
import com.mindtree.utility.Log;
import com.mindtree.utility.PropertyFileReader;


public class Runner{

	private Logger log = (Logger) Log.logger(TestRunner.class.getName());
	
	WebDriver driver; 

	public Runner() throws IOException {
		System.out.println("working");
		driver = ReusableComponents.loadDriver();
	}

	@BeforeTest
	public void homePage() throws IOException {
		driver.manage().window().maximize();
		ReusableMethods.loadURL(driver);
	}

	@Test (priority = 0)
	public void Login() {
    	ReusableMethods.hover(HomePageUI.header_profile, driver);
    	ReusableMethods.click(HomePageUI.Login, driver);
        log.info("opened login page");
	}
		
	@Test (priority = 1,dataProvider="getSearchData")
	public void search(String name) throws IOException {
		ReusableMethods.sendKeys(HomePageUI.search_bar, name, driver);
		ReusableMethods.click(HomePageUI.search_button, driver);
		System.out.println(driver.getTitle());
		log.info("searched for item and verified it");
	}
	
	@Test (priority = 2)
	public void subscribe() throws InterruptedException {
		ReusableMethods.sendKeys(HomePageUI.subscribe_input, "random@gmail.com", driver);
		ReusableMethods.click(HomePageUI.subscribe_btn, driver);
		System.out.print(ReusableMethods.getText(HomePageUI.subscribe_success, driver));
		log.info("searched for item and verified it");
	}
	
	
	@Test (priority = 3)
	public void Google_playapp() throws InterruptedException {
		ReusableMethods.click(HomePageUI.playapp, driver);
		System.out.println(driver.getTitle());
	}
	
	@Test (priority = 4)
	public void iOS_app() throws InterruptedException {
		ReusableMethods.click(HomePageUI.iOSapp, driver);
		System.out.println(driver.getTitle());
	}
	
	@Test(priority=5)
	public void insta() {
		ReusableMethods.click(HomePageUI.insta, driver);
		System.out.println(driver.getTitle());
	}
	
	@Test (priority = 6)
	public void payment_methods(String method) throws InterruptedException {
		
        List<WebElement> pay = ReusableMethods.getElements(HomePageUI.payment_method, driver);
        boolean found = false;
        for(int i=0;i<pay.size();i++) {
        	if(pay.get(i).getAttribute("alt").toLowerCase().contains(method)) {
        		found = true;
        		break;
        	}
        }
        assertTrue(found);
	}
	
	@Test (priority = 7)
	public void offers_bar() throws InterruptedException {
    	String size =new Integer(ReusableMethods.getElements(HomePageUI.n_offers, driver).size()).toString();
    	assertEquals(size,"2");
	}
	

	@Test (priority = 8)
	public void head_alert() throws InterruptedException {
		assertTrue(ReusableMethods.getElement(HomePageUI.header_profile, driver));
	}
	
	
	@Test (priority = 9)
	public void count_furniture() {
    	String size =new Integer(ReusableMethods.getElements(HomePageUI.n_item_furniture, driver).size()).toString();
    	assertEquals(size,21);
	}
	
}
