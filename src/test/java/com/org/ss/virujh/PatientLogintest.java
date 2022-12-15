package com.org.ss.virujh;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PatientLogintest extends Browser{
	
	PatientLogin pl ;
	
	@BeforeTest(groups= {"pass","fail"})
	public void browserlaunch(){
		
		driver = browseropen();
		pl = new PatientLogin(driver);
	}
	
	@Test(priority = 1,groups = {"pass","fail"})
	public void login() throws InterruptedException {
		pl.loginfn();
	}
	
	@Test(priority = 2,groups = "fail")
	public void signinwithoutdata() throws InterruptedException {
		pl.signInwithoutdata();
	}
	
	@Test(priority = 3,groups = "fail")
	public void signinwithoutpasswrd() throws InterruptedException {
		pl.signInwithoutpasswrd();
	}
	
	@Test(priority = 4,groups = "fail")
	public void signinwithoutphonenumber() {
		pl.signInwithoutphonenumber();
	}
	
	@Test(priority = 5,groups = "fail")
	public void signinInvalidpasswrd() {
		pl.signinInvalidpassword();
	}
	
	@Test(priority = 6,groups = "fail")
	public void siginInvalidphonenumber() {
		pl.signinInvalidphonenumber();
	}
	
	@Test(priority = 7,groups = "pass")
	public void signIn() throws InterruptedException {
		pl.signIn();
	}
	
	@AfterTest(groups = "pass")
	public void logout() throws InterruptedException {
		pl.logoutfn();
	}
}
