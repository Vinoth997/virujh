package com.org.ss.virujh;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PatientListinDoctoracctest extends Browser{
	
PatientListinDoctoracc pl;
	
	@BeforeTest
	public void browserlaunch() {
		driver=browseropen();
		pl=new PatientListinDoctoracc(driver);
	}
	
	@Test(priority = 1)
	public void doclogin() throws InterruptedException {
		pl.login();
	}
	
	@Test(priority = 2 ,dependsOnMethods = "doclogin")
	public void patientLists() {
		pl.patientlist();
	}
	
	@Test(priority =3 ,dependsOnMethods = "patientLists")
	public void patientSearch() throws InterruptedException {
		pl.searchpatient();
	}
	
	@Test(priority = 4,dependsOnMethods = "patientSearch")
	public void patientDetailView() throws InterruptedException {
		pl.patientdetailview();
	}
	
	@Test(priority = 5)
	public void upcomingBooking() throws InterruptedException {
		pl.upcomingbooking();
	}
	
	@Test(priority = 6)
	public void pastBooking() throws InterruptedException {
		pl.pastbooking();
	}
	
	@Test(priority = 7)
	public void videocallfn() {
		pl.videoconsulting();
	}

}
