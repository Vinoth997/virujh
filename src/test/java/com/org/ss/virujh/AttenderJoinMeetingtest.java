package com.org.ss.virujh;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AttenderJoinMeetingtest extends Browser{
	
	AttenderJoinMeeting aj;
	
	@BeforeTest
	public void Browser() throws InterruptedException {
		browseropen();
		aj = new AttenderJoinMeeting(driver);
		aj.login();
	}
	
	
	@Test(priority = 1)
	public void WithoutData() {
		aj.withoutdata();
	}
	
	@Test(priority = 2)
	public void WithoutMeetingID() throws InterruptedException {
		aj.withoutmeetingid();
	}
	
	@Test(priority = 3)
	public void WithoutPasscode() throws InterruptedException {
		aj.withoutpasscode();
	}
	
	@Test(priority = 4)
	public void ValidMeetingIdInvalidPasscode() throws InterruptedException {
		aj.validmeetingidinvalidpasscode();
	}
	
	@Test(priority = 5)
	public void InvalidMeetingIdValidPasscode() throws InterruptedException {
		aj.invalidmeetingidvalidpasscode();
	}
	
	@Test(priority = 6)
	public void InvaliMeetingIdInvalidPasscode() throws InterruptedException {
		aj.invalidmeetinidinvalidpasscode();
	}
	
	@Test(priority = 7)
	public void ValidMeetingIdValidPasscode() throws InterruptedException {
		aj.validmeetingidvalidpasscode();
	}
	
	@AfterMethod
	public void Refresh() {
		driver.navigate().refresh();
	}
	
	@AfterTest
	public void TearDown() {
		driver.quit();
	}
	
}
