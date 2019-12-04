package com.osa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Browser {
	public static WebDriver dr;
	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/mdobaidulla/Desktop/chromedriver");
		dr=new ChromeDriver();
	}
@AfterTest	
public void closeBrowser() throws InterruptedException {
	Thread.sleep(5000);
	dr.close();
	}

}
