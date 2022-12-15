package com.org.ss.virujh;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DoctorPersonalSettingstest extends Browser{
	
	DoctorPersonalSettings dps;
	
	@BeforeTest
	public void browserLaunch() {
		browseropen();
		dps = new DoctorPersonalSettings(driver);
	}
	
	@Test(priority = 1)
	public void login() throws InterruptedException {
		dps.login();
	}
	
	@Test(priority = 2)
	public void settings() {
		dps.settings();
	}
	
	@Test(priority = 3)
	public void doctorPersonalsettings() throws InterruptedException {
		dps.doctorpersonalsettings();
	}
}
