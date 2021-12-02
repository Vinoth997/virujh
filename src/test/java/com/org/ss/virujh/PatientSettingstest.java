package com.org.ss.virujh;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PatientSettingstest extends Browser{
	PatientSettings ps;

	@BeforeTest
	public void browserlaunch(){
		driver = browseropen();
		ps =new PatientSettings(driver);
	}

	@Test(priority = 1)
	public void patientsignin() throws InterruptedException {
		
		ps.patientLogin();
		
	}
	
	@Test(priority = 2,dependsOnMethods = "patientsignin")
	public void patientsettingspage() throws InterruptedException {

		ps.Settingsbtn();

	}

	@Test(priority = 3,dependsOnMethods = "patientsettingspage")
	public void ImageUpload() throws InterruptedException {

		ps.uploadImage();
	}
	
	@Test(priority = 4,dependsOnMethods = "ImageUpload")
	public void SettingsFields() throws InterruptedException {
		ps.Fields();
	}

	@Test(priority = 5,dependsOnMethods = "SettingsFields")
	public void ReportUpload() throws InterruptedException {

		ps.reportPage();
	}

	@Test(priority = 6,dependsOnMethods = "ReportUpload")
	public void SearchDocument() throws InterruptedException {

		ps.searchdocument();
	}

	@Test(priority = 7,dependsOnMethods = "SearchDocument")
	public void DownloadDocument() {

		ps.downloaddoc();
	}

	@Test(priority = 8,dependsOnMethods = "DownloadDocument")
	public void Reports() throws InterruptedException {

		ps.deletedoc();
	}

}
