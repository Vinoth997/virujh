package com.org.ss.virujh;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PatientSignuptest extends Browser {
	public WebDriver driver;
	PatientSignup patient;

	@BeforeTest
	public void BrowserOpen() {
		driver = browseropen();
		patient = new PatientSignup(driver);
	}

	@Test(priority = 1)
	public void signUpbt() throws InterruptedException {		
		patient.signUpbtn();
	}

	@Test(priority = 2)
	public void patientSignup() throws InterruptedException {	
		patient.patientTab();

	}
    
	@Test(dependsOnMethods = "patientSignup")
	public void emptyFields()
	{
	 patient.emptyfields();	
	}
	
	@Test(dependsOnMethods = "emptyFields")
	public void negativeEntry() throws InterruptedException {
		patient.invalid();
	}
	
	@Test(dependsOnMethods = "negativeEntry")
	public void clearingEnteredFields() throws InterruptedException {
		patient.clearingfields();
	}
	
	@Test(priority = 3)
	public void patprefi() throws InterruptedException {
		
		patient.patpre();
	}

	@Test(priority = 4)
	public void patiGender() throws InterruptedException {		
		patient.patGender();
	}

	@Test(priority = 5)
	public void patFirstLastname() {		
		patient.pFstLstname("Karthik", "Raja");
	}

	@Test(priority = 6)
	public void contaltrcontnumber() {
		patient.pContAltNumber("9876543212", "8896543452");
	}

	@Test(priority = 7)
	public void patiemail() {		
		patient.pateMail("stringemail@gmail.com");
	}

	@Test(priority = 8)
	public void patieDateofBirth() throws InterruptedException {
		patient.pDateOfBrth();
	}

	@Test(priority = 9)
	public void patientAge() {
		patient.patAge();
	}

	@Test(priority = 10)
	public void patientAdd() {
		patient.patAddress("1A Second Colony\nThird Street\nFourthcity");
	}

	@Test(priority = 11)
	public void patientCity() {
		patient.patCity("Kalakad");
	}

	@Test(priority = 12)
	public void patientState() {
		patient.patState("TamilNadu");
	}

	@Test(priority = 13)
	public void patientCountry() {
		patient.patCountry("India");
	}

	@Test(priority = 14)
	public void patientPincode() {
		patient.patPincod("623008");
	}

	@Test(priority = 15)
	public void patientPassword() {
		patient.patPasswrd("Abcd0987$");
	}

	@Test(priority = 16)
	public void passwordshow() {
		patient.patPassShow();
	}

	@Test(priority = 17)
	public void patientConfrmpass() {
		patient.patConfrmPass("Abcd0987$");
	}

	@Test(priority = 18)
	public void cpnfrmPassshow() {
		patient.patConfrmPassShow();
	}

	@Test(priority = 19)
	public void submitBtn() throws InterruptedException {
		patient.submit();
	}

}
