package com.org.ss.virujh;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DoctorHolidayValidationtest extends Browser {
	
	DoctorHolidayValidation dh;
	
	@BeforeTest
	public void Browser_Open() {
		browseropen();
		dh = new DoctorHolidayValidation(driver);
	}
	
	@Test(priority = 1)
	public void Login() throws InterruptedException {
		dh.doctor_login();
	}
	
	@Test(priority = 2)
	public void Appoinment() {
		dh.appoinments();
	}
	
	@Test(priority = 3)
	public void Holiday_Btn() throws InterruptedException {
		dh.holiday_btn();
	}
	
	@Test(priority = 4)
	public void Holiday_List() throws InterruptedException {
		dh.holiday_list();
	}
}
