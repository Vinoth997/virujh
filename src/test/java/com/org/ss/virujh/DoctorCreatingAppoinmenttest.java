package com.org.ss.virujh;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DoctorCreatingAppoinmenttest extends Browser{

	DoctorCreatingAppoinment dl;
	
	@BeforeTest(groups= {"1","2"})
	public void browserlaunch(){
		
		driver = browseropen();
		dl = new DoctorCreatingAppoinment(driver);
	}
	
	@Test(priority = 1,groups= {"1","2"})
	public void DoctorLogin() throws InterruptedException {		
		dl.loginfn();
	}
	
	@Test(dependsOnMethods = "DoctorLogin",groups= {"1","2"})
	public void Appoinmentfunc() {	
		dl.appoinmentfn();
	}
	
	@Test(dependsOnMethods = "Appoinmentfunc",groups= {"1"})
	public void CreateAppoinment() throws InterruptedException {
		dl.freeslotcreateappoinment();
		dl.createAppoinment();
	}
	
	@Test( groups= {"2"})
	public void Date() {
		dl.availabledate();
	}
	
	@Test(dependsOnMethods = "Appoinmentfunc")
	public void Logoutfunction() throws InterruptedException {

        //dl.logoutfn();
	}
	
	@AfterTest
	public void browserclose() {
		//driver.close();
	}

}
