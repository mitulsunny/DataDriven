package com.osa.common;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.osa.base.Browser;

public class Utility extends Browser{
	/**
	 * The verifyTitle method will take two parameters
	 * and will verify the expected and actual titles are equals or not
	 * @param actual
	 * @param expected
	 */
	public static void verifyTitle( String actual,String expected) {
		if(expected.equals(actual)) {
			System.out.println("The expected and actual page title is matched");
		}else {
			System.out.println("The Expected Title is :"+expected);
			System.out.println("The Actual Title is :"+actual);
			Assert.assertEquals(actual, expected);

		}
	}
	public static void typeText(String idValue,String text) {
		dr.findElement(By.id(idValue)).clear();
		dr.findElement(By.id(idValue)).sendKeys(text);
	}
	@DataProvider(name="myTestData")
	public Object[][] getData(){
		Object object[][]=null;
		try {
			object= ExcelRead.getTestData("C:\\Users\\rahma\\Desktop\\TestData.xlsx","loginTestData");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return object;
	}
	
}
