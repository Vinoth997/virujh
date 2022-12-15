package com.org.ss.virujh;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DocHospitalSettingstest extends Browser {
	
	DocHospitalSettings dh;
	
	@BeforeTest
	public void BrowserLaunch() {
		browseropen();
		dh = new DocHospitalSettings(driver);
	}
	
	@Test(priority = 1)
	public void Login() throws InterruptedException {
		dh.login();
	}
	
	@Test(priority = 2)
	public void HospitalSettings() throws InterruptedException {
		dh.hospitalSettings();
	}
}
