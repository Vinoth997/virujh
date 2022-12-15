package com.org.ss.virujh;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DoctorChangePasswordtest extends Browser{
	
	DoctorChangePassword dc;
	
	@BeforeTest
	public void BrowserLaunch() throws InterruptedException {
		browseropen();
		dc = new DoctorChangePassword(driver);
		dc.login();
	}
	
	@BeforeMethod
	public void ChangePassword() {
		dc.changepassword();
	}
	
	@Test(priority = 1)
	public void WithoutData() throws InterruptedException {
		dc.withoutdata();
	}
	
	@Test(priority = 2)
	public void InvalidNewPassword() throws InterruptedException {
		dc.invalidnewpassword();
	}
	
	@Test(priority = 3)
	public void InvalidconfirmPassword() throws InterruptedException {
		dc.invalidconfirmpassword();
	}
	
	@Test(priority = 4)
	public void MaxLengthPassword() throws InterruptedException {
		dc.invalidmaxlenght();
	}
	
	@Test(priority = 5)
	public void MinLengthPassword() throws InterruptedException {
		dc.invalidminlength();
	}
	
	@Test(priority = 6)
	public void GivingCurrentpassToNewPass() throws InterruptedException {
		dc.givingSamecurrentpassToNewpass();
	}
	
	@Test(priority = 7)
	public void InvalidCurrentPassword() throws InterruptedException {
		dc.invalidcurrentpassword();
	}
	
	@AfterMethod
	public void PageRefresh() {
		driver.navigate().refresh();
	}
	
	@AfterTest
	public void TearDown() {
		driver.quit();
	}
}
