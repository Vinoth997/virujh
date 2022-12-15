package com.org.ss.virujh;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PatientAmountCollectiontest extends Browser {

	PatientAmountCollection amt;
	
	@BeforeTest
	public void BrowserLaunch() {
		browseropen();
		amt = new PatientAmountCollection(driver);
	}
	
	@Test(priority = 1)
	public void Loginfn() throws InterruptedException {
		amt.login();
	}
	
	@Test(priority = 2)
	public void AmountCollection() {
		amt.reporttab();
	}
	
	@Test(priority = 3)
	public void AmountReportPeriod() throws InterruptedException {
		amt.amountReportPeriod();
	}
	
	@Test(priority = 4)
	public void SearchPatient() {
		amt.searchpatient();
	}
	
	@Test(priority = 5)
	public void PatientList() {
		amt.patientList();
	}
	
	@Test(priority = 6)
	public void AmountCalc() {
		amt.amountCal();
	}
	
	@Test(priority = 7)
	public void ReportExport() {
		amt.reportExport();
	}
}
