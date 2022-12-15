package com.org.ss.virujh;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import src.main.java.com.org.ss.virujh.AppoinmentRecordsinDocacc;

public class AppoinmentRecordsinDocacctest extends Browser{
	
AppoinmentRecordsinDocacc ar;
	
	@BeforeTest
	public void browserLaunch() {
		driver=browseropen();
		ar = new AppoinmentRecordsinDocacc(driver);
	}
	
	@Test(priority = 1)
	public void Login(){
		ar.login("vinothkumar.c@softsuave.com", "Vinoth123#");
	}
	
	@Test(priority = 2)
	public void Reports() throws InterruptedException {
		ar.reports();
	}
	
	@Test(priority = 3)
	public void fromDate() {
		ar.fromdate();
	}
	
	@Test(priority = 4)
	public void toDate() {
		ar.todate();
	}
	
	@Test(priority = 5)				
	public void selectBtn() {
		ar.selectbtn();
	}
	
	@Test(priority = 6)
	public void searchReport() {
		ar.searchpatientreport();
	}
	
	@Test(priority = 6)
	public void patientAppoinmentReports() {
		ar.patientappoinmentreports();
	}
	
	@Test(priority = 7)
	public void exportReports() {
		ar.exportreports();
	}
	
	@Test(dependsOnMethods = "exportReports")
	public void amountCollectionrep() throws InterruptedException {
		ar.amountcollectionrep();
	}

}
