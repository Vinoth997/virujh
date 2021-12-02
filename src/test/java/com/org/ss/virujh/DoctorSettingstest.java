package com.org.ss.virujh;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DoctorSettingstest extends Browser{

	DoctorSettings ds;
	
	@BeforeTest
	public void browserlaunch() {
		driver=browseropen();
		ds=new DoctorSettings(driver);
	}
	
	@Test(priority = 1)
	public void DoctorLogin() throws InterruptedException {
		ds.login("vinothkumar.c@softsuave.com", "Vinoth123#");
	}
	
	@Test(dependsOnMethods = "DoctorLogin")
	public void Settingsmenu() throws InterruptedException {
		ds.settingsmenu();
	}
	
	@Test(dependsOnMethods = "Settingsmenu")
	public void Cancellation() throws InterruptedException {
		ds.cancellationopt();
		ds.patirntcancellationopt();
	}	
	
	@Test(dependsOnMethods = "Cancellation")
	public void PatientReschedule() throws InterruptedException {
		ds.patientreschedulechkbtn();
	}
	
	@Test(dependsOnMethods = "PatientReschedule")
	public void WorkSchedules() throws InterruptedException {
		ds.workschedules();
		ds.consultationtime();
		ds.selectingday();
	}
	
	@Test(dependsOnMethods = "WorkSchedules")
	public void InTime() throws InterruptedException {
		ds.intimeselect();
	}
	
	@Test(dependsOnMethods = "InTime")
	public void LeaveTime() throws InterruptedException {
		ds.leavetimeselect();
	}

}
