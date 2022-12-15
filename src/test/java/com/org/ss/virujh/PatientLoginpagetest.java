package com.org.ss.virujh;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PatientLoginpagetest extends Browser 
{
    PatientLoginpage loginpage;
	
	@BeforeTest
	public void Browserlaunch() {
		driver=browseropen();
		loginpage= new PatientLoginpage(driver);
	}
	
	@Test(priority = 1)
	public void login() throws InterruptedException{
		
		loginpage.loginButton();
		loginpage.patientButton();
	}
	
	@Test(priority = 2)
	public void Emptyfields() {
		loginpage.emptyfields();
	}
	
	@Test(dependsOnMethods = "Emptyfields")
	public void Patientlogin() throws InterruptedException {

		loginpage.userName("9876543222");
		loginpage.passwordd("Arulraj123#");
		loginpage.signInbtn();
		
	}
	
	@Test(priority = 3)
	public void FindDoctor() throws InterruptedException {
		loginpage.findDoctorbtn();
		loginpage.searchDoctor("vijay kumar");
		loginpage.bookapoinment();
		
	}
	
	@Test(priority = 4)
	public void BookingDateSelect() throws InterruptedException {
        loginpage.selectingDate();
        loginpage.confirmButton();
	}
	
	@Test(dependsOnMethods = "BookingDateSelect")
	public void PaymentDetails() throws InterruptedException{
		loginpage.paymentMethod();
	}

	@AfterTest
	public void PatientLogout() throws InterruptedException{
		Thread.sleep(4000);
		System.out.println("Test Executed");
		loginpage.profileButton();
		loginpage.logoutButton();
		System.out.println("Test Executed");
	}
	
}

