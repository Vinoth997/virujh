package com.org.ss.virujh;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PatientForgotPasswordtest extends Browser{

	PatientForgotPassword pf;
	
	@BeforeTest
	public void browserlaunch(){
		
		driver = browseropen();
		System.out.println(driver);
		pf = new PatientForgotPassword(driver);
	}
	
	@Test(priority=1)
	public void Patientlogin() {
		//ForgotPassword fp=new ForgotPassword(driver);
		pf.patienttab();
	}
	
	@Test(priority=2)
	public void ForgotPasswordfields() throws InterruptedException {
		//ForgotPassword fp=new ForgotPassword(driver);
		pf.forgotpasswordfields();
	}
	
	@Test(priority=5)
	public void ForgotPasswordFn() throws InterruptedException {
		//ForgotPassword fp=new ForgotPassword(driver);
		pf.forgotPasswordfn();
	}
	
	@Test(priority=3)
	public void errormsg() {
		//ForgotPassword fp=new ForgotPassword(driver);
		pf.withoutnum();
	}
	
	@Test(priority=4)
	public void invalidnum() {
		pf.invalidnum();
	}


}
