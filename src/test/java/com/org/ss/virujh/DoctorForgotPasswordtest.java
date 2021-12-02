package com.org.ss.virujh;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DoctorForgotPasswordtest extends Browser{
	
	DoctorForgotPassword dp;

	@BeforeTest
	public void browserlaunch(){
		driver=browseropen();
		dp=new DoctorForgotPassword(driver);
	}

	@Test(priority = 1)
	public void doclogin() {
	
		dp.doctorlogintab();
	}
	
	@Test(priority = 2)
	public void Forgotpasswrdfields() {
		
		dp.forgtpassfields();
	}
	
	@Test(priority = 3)
	public void emptyField() {
		
		dp.noemail();
	}
	
	@Test(priority = 4)
	public void invalidemail() {
		
		dp.invalidmail();
	}
	
	@Test(priority = 5)
	public void UnregisteredMail() {
		
		dp.unregisteredmail();
	}
	
	@Test(dependsOnMethods = "UnregisteredMail")
	public void ValidEmail() throws InterruptedException {
		
		dp.validmail();
	}

}
