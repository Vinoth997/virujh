package com.org.ss.virujh;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DoctorHolidayListtest extends Browser{
	DoctorHolidayList dh;
	
	@BeforeTest(groups = {"1","2","3","4"})
	public void Browser_Launch() {
		browseropen();
		dh = new DoctorHolidayList(driver);
	}
	
	@Test(priority = 1,groups = {"1","2","3","4"})
	public void Doctor_Signin() throws InterruptedException {
		dh.login_as_Doctor();
	}
	
	@Test(priority = 2,groups = {"1","2","3","4"})
	public void Work_Schedule() {
		dh.work_schedule();
	}
	
	@Test(priority = 3)
	public void Title_Validation() {
		dh.title_validation();
	}
	
	@Test(priority = 4,groups = "1")
	public void Add_Holiday_Date() throws InterruptedException {
		dh.without_data();
	}
	
	@Test(priority = 5,groups = "1")
	public void Holiday_From_Date() throws InterruptedException {
		dh.holiday_from_date();
	}
	
	@Test(priority = 6,groups = "1")
	public void Holiday_To_Date() throws InterruptedException {
		dh.holiday_to_date();
	}
	
	@Test(priority = 7,groups = "1")
	public void Description() throws InterruptedException {
		dh.add_description();
	}
	
	@Test(priority = 8,groups = "1")
	public void Save_Holiday() throws InterruptedException {
		dh.save_holiday();
	}
	
	@Test(priority = 9,groups = "1")
	public void Updated_message() {
		dh.updated_successfully();
	}
	
	@Test(priority = 10,groups = "2")
	public void Existing_Date() throws InterruptedException {
		dh.existing_date();
	}
	
	@Test(priority = 4,groups = "3")
	public void Holiday_List() throws InterruptedException {
		dh.holiday_list();
	}
	
	@Test(priority = 3,groups = "")
	public void Delete_Holiday() throws InterruptedException {
		dh.delete_holiday_list();
	}
	
	@Test(priority = 3,groups = "4")
	public void delete_by_vacation() throws InterruptedException{
		dh.vacation();
	}

}
