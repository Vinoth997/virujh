package com.org.ss.virujh;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ReschedulePatientAppoinmenttest extends Browser{

	ReschedulePatientAppoinment rp;
	
	@BeforeTest
	public void BrowserLaunch() throws InterruptedException {
		driver = browseropen();
		rp = new ReschedulePatientAppoinment(driver);
		rp.signin();
	}
	
	@BeforeMethod
	public void Appoinments() throws InterruptedException {
		rp.appoinments();
	}
	
	@Test(priority = 1)
	public void RescheduleAppoinment() {
		rp.reschedule();
	}
	
	@Test(priority = 2)
	public void CancelAppoinment() {
		rp.cancelappoinment();
	}
	
	@AfterMethod
	public void Refresh() {
		//driver.navigate().refresh();
	}
}
