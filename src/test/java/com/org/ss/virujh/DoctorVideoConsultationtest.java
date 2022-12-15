package com.org.ss.virujh;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DoctorVideoConsultationtest extends Browser {
	
	DoctorVideoConsultation dvc;
	
	@BeforeTest
	public void Launch_Browser() {
		browseropen();
		dvc = new DoctorVideoConsultation(driver);
	}
	
	@Test(priority =1)
	public void Doctor_SignIn() throws InterruptedException {
		dvc.doctor_signin();
	}
	
	@Test(priority =2)
	public void Doctor_Video_Conslt() throws InterruptedException {
		dvc.doc_video_consultation();
	}
	
	@Test(priority =3)
	public void Prescription() throws InterruptedException {
		dvc.prescription_window();
	}
	
	@Test(priority =4)
	public void Next_Session() throws InterruptedException {
		dvc.next_session();
	}
	
	@Test(priority =5)
	public void Prescription_validation() throws InterruptedException {
		dvc.prescription_validation();
	}
	
	@Test(priority =6)
	public void End_Session() {
		dvc.end_call();
	}
}
