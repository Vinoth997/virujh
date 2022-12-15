package com.org.ss.virujh;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PatientBookingAppoinmenttest extends Browser 
{
    PatientBookingAppoinment pba;
	
	@BeforeTest(groups = {"1","2"})
	public void Browserlaunch() {
		driver = browseropen();
		pba = new PatientBookingAppoinment(driver);
	}
	
	@Test(priority = 1,groups= {"1","2"})
	public void login() throws InterruptedException{
		pba.login();
	}
	
	@Test(priority = 2,groups= {"1","2"})
	public void FindDoctor() throws InterruptedException {
		pba.findDoctorbtn();
		pba.searchDoctor("vijay kumar");
		pba.bookapoinment();
		
	}
	
	@Test(priority = 3,groups= {"1","2"})
	public void BookingDateSelect() throws InterruptedException {
        pba.selectingDate();
        pba.confirmButton();
	}
	
	@Test(dependsOnMethods = "BookingDateSelect",groups="2")
	public void PaymentDetails() throws InterruptedException{
		pba.paymentMethod();
	}

	/*@AfterTest
	public void PatientLogout() throws InterruptedException{
		Thread.sleep(4000);
		loginpage.profileButton();
		loginpage.logoutButton();
	}*/
	
}

