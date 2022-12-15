package com.org.ss.virujh;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PatientVideoConsultationtest extends Browser{
	
	PatientVideoConsultation pvc;
	
	@BeforeTest
	public void Launch_Browser() {
		edgebrowseropen();
		//firefoxbrowseropen();
		pvc = new PatientVideoConsultation(driver);
	}
	
	@Test(priority = 1)
	public void Patient_SignIn() throws InterruptedException {
		pvc.patient_signin();
	}
	
	@Test(priority = 2)
	public void Patient_Upcoming_appoinments() throws InterruptedException {
		pvc.patient_upcoming_appoinment();
	}
	
	@Test(priority = 3)
	public void Prescription_Validation() {
		pvc.prescription_validation();
	}
}
