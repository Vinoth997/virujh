package com.org.ss.virujh;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
//@Listeners(listeners.TestNGlisteners.class)
public class HomePagetest extends Browser{
	
	HomePage lp;
	
	@BeforeMethod
	public void browserlaunch() {
		browseropen();
		lp = new HomePage(driver);
	}
	
	@Test(priority = 1)
	public void linktest() {
		lp.checkinglinks();
	}
	
	@Test(priority = 2)
	public void AppStore() throws InterruptedException {
		lp.appstore();
	}
	
	@Test(priority = 3)
	public void Playstore() throws InterruptedException {
		lp.playstore();
	}

}
