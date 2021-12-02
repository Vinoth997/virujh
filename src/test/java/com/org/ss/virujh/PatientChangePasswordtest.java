package com.org.ss.virujh;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PatientChangePasswordtest extends Browser {
	
	PatientChangePassword pcp;
	
	@BeforeTest
	public void browserlaunch(){
		browseropen();
		pcp = new PatientChangePassword(driver);
	}
	
	@Test
	public void Login() throws InterruptedException {
		pcp.login();
	}
	
	@Test(dependsOnMethods = "Login")
	public void ChangePasswordfn() throws InterruptedException {
		pcp.changePasswordfn();
	}

}
