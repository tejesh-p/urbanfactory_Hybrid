package com.mindtree.reusablecomponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.mindtree.utility.PropertyFileReader;

public class ReusableComponents {
	public static WebDriver loadDriver() throws IOException {
		System.out.println("working");
		System.setProperty("webdriver.chrome.driver", PropertyFileReader.loadFile().getProperty("ChromeDriverPath"));
		System.out.println("working");
		WebDriver driver = new ChromeDriver();
		
		//driver.manage().window().maximize();
		//ReusableMethods.timelapse(driver);
		System.out.println("working");
		return driver;
	}
	
}
