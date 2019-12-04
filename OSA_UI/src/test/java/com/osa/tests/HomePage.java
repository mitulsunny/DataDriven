package com.osa.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.osa.base.Browser;
import com.osa.common.Utility;

public class HomePage extends Browser{
//	@Ignore
//	@Test(priority=1)
//	public void verifyHomePageTitle(){
//		dr.get("https://www.osaconsultingtech.com");
//		String expectedTitle="OSA Consulting Tech";
//		Utility.verifyTitle(dr.getTitle(),expectedTitle);
//	}
//	@Ignore
//	@Test(priority=2)
//	public void clickOnForumLoginButton() {
//		dr.findElement(By.xpath("//a[contains(text(),'Forum Login')]")).isDisplayed();
//		dr.findElement(By.xpath("//a[contains(text(),'Forum Login')]")).click();
//		String expectedTitle="Forum Login";
//		Utility.verifyTitle(dr.getTitle(),expectedTitle);
//	}
	@Test(dataProvider="myTestData", dataProviderClass=Utility.class)
	public void verifyForumLogin(String username,String password) throws InterruptedException {
		dr.get("https://www.osaconsultingtech.com");
		String expectedTitle="OSA Consulting Tech";
		Utility.verifyTitle(dr.getTitle(),expectedTitle);
		dr.findElement(By.xpath("//a[contains(text(),'Forum Login')]")).click();
		String expectedTitle1="Forum Login";
		Utility.verifyTitle(dr.getTitle(),expectedTitle1);
		Utility.typeText("username", username);
		Utility.typeText("password", password);
		Thread.sleep(4000);
		dr.findElement(By.id("login_button")).click();
	}

}
