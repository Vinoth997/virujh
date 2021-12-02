package com.org.ss.virujh;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DoctorLoginfntest extends Browser{
	DoctorLoginCredential dl;

	@BeforeTest(groups = {"pass","fail"})
	public void browserLaunch() {
		browseropen();
		dl = new DoctorLoginCredential(driver);
	}
	
	@Test(priority = 1,groups = {"pass","fail"})
	public void login() throws InterruptedException {
		dl.login();
	}
	
	@Test(priority = 2,groups = "fail")
	public void signinwithoutdata() throws InterruptedException {
		dl.signInwithoutdata();
	}
	
	@Test(priority = 3,groups = "fail")
	public void signinwithoutpasswrd() throws InterruptedException {
		dl.signInwithoutpasswrd();
	}
	
	@Test(priority = 4,groups = "fail")
	public void signinwithoutmail() {
		dl.signInwithoutmail();
	}
	
	@Test(priority = 5,groups = "fail")
	public void signinInvalidpasswrd() {
		dl.signinInvalidpassword();
	}
	
	@Test(priority = 6,groups = "fail")
	public void siginInvalidmail() {
		dl.signinInvalidmail();
	}
	
	@Test(priority = 7,groups = "pass")
	public void signIn() throws InterruptedException {
		dl.signIn();
	}
}
