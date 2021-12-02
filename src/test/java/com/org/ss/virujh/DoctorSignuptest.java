package com.org.ss.virujh;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DoctorSignuptest extends Browser{

	DoctorSignup ds;
	
	@BeforeTest
	public void browserLaunch() {
		driver=browseropen();
		//ds=new DoctorSignup(driver);
	}
	
	@Test(priority = 1)
	public void LoginasDoctor() {
		ds.loginasdoctor();
	}
	
	@Test(dependsOnMethods = "LoginasDoctor")
	public void EmptyFields() throws InterruptedException {
		ds.emptyfields();
	}
	
	@Test(dependsOnMethods = "EmptyFields")
	public void InvalidEntry() throws InterruptedException {
		ds.invalidentry();
	}
	
	@Test(dependsOnMethods = "InvalidEntry")
	public void ClearingFields() throws InterruptedException {
		ds.clearfields();
	}
	
	@Test(priority = 2)
	public void ValidEntry() throws InterruptedException {
		ds.validentry("Vetri", "Maran", "Free Clinic", "Dentist", "DDS", "404", "D01", "12", "9988771122", "doctor012@mail.com", "Doctor01#", "Doctor01#");
	}

}
