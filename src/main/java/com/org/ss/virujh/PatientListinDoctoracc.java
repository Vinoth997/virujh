package com.org.ss.virujh;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PatientListinDoctoracc {
	
	WebDriver driver;
	
	By patientsbtn    = By.xpath("//a//i[@title='Patients']");
	By patientrec     = By.xpath("//td");
	By searchpatient  = By.xpath("//input[@type='text']");
	By viewdetbtn     = By.xpath("(//button[@type='button'])[3]");
	By patientdet	  = By.xpath("//button//span[text()='Patient Details']");
	By appoinmntbt    = By.xpath("(//span[@class='MuiTab-wrapper'])[2]");
	By upcomingbk     = By.xpath("//span[@class='upcoming-tab appointment-tab active']");  
	By upcomingbklist = By.xpath("//div[@class=\'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-6\']");
	By pastbk         = By.xpath("//span[@class='past-tab appointment-tab']");
	By pastbklist     = By.xpath("//div[@class='MuiGrid-root MuiGrid-item']");
	By backbtn		  = By.xpath("//img[@alt='Left Arrow']");

	public PatientListinDoctoracc(WebDriver driver) {
		this.driver=driver;
	}
	
	public void login() throws InterruptedException {
		DoctorLoginCredential dl = new DoctorLoginCredential(driver);
		dl.login();
		dl.signIn();
	}
	
	public void patientlist() {
		try{
			driver.findElement(patientsbtn).click();
			List<WebElement> li=driver.findElements(patientrec);
			for(WebElement txt:li) {
				String text=txt.getText();
				System.out.println(text);
			}}
		catch(NoSuchElementException e) {
			System.out.println("No records found");
		}
	}
	
	public void searchpatient() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(searchpatient).sendKeys("Arul");
	}
	
	public void patientdetailview() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(viewdetbtn).click();
		String et=driver.findElement(By.xpath("//div[@role='tablist']")).getText();
		System.out.println(et);
		driver.findElement(patientdet).click();
		String text = driver.findElement(By.xpath("//h3")).getText();
		System.out.println(text);
		List<WebElement> patdet = driver.findElements(By.xpath("//td"));
		for(WebElement detail : patdet) {
			String det = detail.getText();
			System.out.println(det);
		}
		Thread.sleep(3000);
		driver.findElement(appoinmntbt).click();
		String ett=driver.findElement(By.xpath("//div[@class='appointment-type-tab']")).getText();
		System.out.println(ett);
	}

	public void upcomingbooking() throws InterruptedException {
		
		driver.findElement(upcomingbk).click();
		Thread.sleep(3000);
		//Upcoming Booking list
		System.out.println("\nUpcoming Booking lists : \n");
		try{
		List<WebElement> elt=driver.findElements(upcomingbklist);
		for(WebElement txt:elt) {
			String text=txt.getText();
			System.out.println("----------------------------------------------------------------------");
			System.out.println("\n"+text+"\n");
		}}
		catch(NoSuchElementException e) {
			System.out.println("No upcoming appointments");
		}
		
//		catch(NoSuchElementException e) {
//			WebElement rec = driver.findElement(By.xpath("//div[@class='appointment-content-wrap']//div//div"));
//			String nofile = rec.getText();
//			System.out.println(nofile);
//			//System.out.println("No upcoming appointments");
//		}
	}
	
	public void pastbooking() throws InterruptedException {
		driver.findElement(pastbk).click();
		//Past Booking list
		Thread.sleep(3000);
		System.out.println("\nPast Booking lists : \n");
		List<WebElement> elt1=driver.findElements(pastbklist);
		for(WebElement txt1:elt1) {
			String text1=txt1.getText();
			System.out.println("----------------------------------------------------------------------");
			System.out.println("\n"+text1+"\n");
		}
	}
	
	public void videoconsulting() {
		
		driver.findElement(By.xpath("//span[text()='VIDEO CONSULTATION']")).click();
		boolean disp = driver.findElement(By.xpath("//div[@role='dialog']")).isDisplayed();
		System.out.println("Video call dialog displayed : "+disp);
		
		boolean micbtn = driver.findElement(By.xpath("(//span[@class='MuiIconButton-label'])[1]")).isEnabled();
		boolean videobtn = driver.findElement(By.xpath("(//span[@class='MuiIconButton-label'])[2]")).isEnabled();
		System.out.println("Mic button is enabled : "+micbtn);
		System.out.println("Video button is enabled : "+videobtn);
	}

}
