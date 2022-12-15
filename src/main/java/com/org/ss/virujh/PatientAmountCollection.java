package com.org.ss.virujh;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PatientAmountCollection {

	WebDriver driver;
	
	By reports         = By.xpath("//i[@title='Reports']");
	By reptablist      = By.xpath("//div[@role='tablist']//span[@class='MuiTab-wrapper']");
	By amtcollection   = By.xpath("//span[contains(text(),'Collection')]");
	By reportperiod    = By.xpath("//input[contains(@value,'select the period')]");
	By fromdate        = By.xpath("//input[@placeholder='Early']");
	By todate	       = By.xpath("//input[@placeholder='Continuous']");
	By monthselectr    = By.xpath("//span[@class='rdrMonthPicker']//select");
	By yearselectr     = By.xpath("//span[@class='rdrYearPicker']//select");
	By dateselectr     = By.xpath("(//div[@class='rdrDays'])[2]//button");
	By search		   = By.xpath("//input[@name='searchText']");
	By nextbtn         = By.xpath("//button[@class='rdrNextPrevButton rdrNextButton']");
	By previousbtn     = By.xpath("//button[@class='rdrNextPrevButton rdrPprevButton']");
	By select          = By.xpath("//span[text()='Select']");
	By reportexport    = By.xpath("//div[@class='ExportButton']");
	By patientlist     = By.xpath("//td//parent::tr");
	By patcompleted    = By.xpath("//tr//td[text()='Completed']/ancestor::tr");
	By patincompleted  = By.xpath("//tr//td[text()='Not Completed']/ancestor::tr");
	By amount          = By.xpath("//th[text()='Amount']//following::td//span//ancestor::td");
	
	public PatientAmountCollection(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login() throws InterruptedException {
		DoctorLogin dl = new DoctorLogin(driver);
		dl.login();
		dl.signIn();
	}
	
	public void reporttab() {
		driver.findElement(reports).click();
		List<WebElement> tabs = driver.findElements(reptablist);
		for(WebElement pattabs:tabs) {
			String patabs = pattabs.getText();
			System.out.println(patabs);
		}
	}
	
	public void amountReportPeriod() throws InterruptedException {
		driver.findElement(amtcollection).click();
		Thread.sleep(3000);
		driver.findElement(reportperiod).click();
		Thread.sleep(2000);
		driver.findElement(fromdate).click();
		Thread.sleep(3000);
		//From
		Select month = new Select(driver.findElement(monthselectr));
		month.selectByVisibleText("October");
		Select year = new Select(driver.findElement(yearselectr));
		year.selectByVisibleText("2021");
		
		List<WebElement> date = driver.findElements(dateselectr);
		for(int i=0;i<date.size();i++) {
			String datee = date.get(i).getText();
			//System.out.println(datee);
			if(datee.equalsIgnoreCase("1")) {
				if(date.get(i).isDisplayed()) {
					date.get(i).click();
					break;
				}
			}
		}
		
		//To
		Thread.sleep(2000);
		driver.findElement(todate).click();
		Thread.sleep(3000);
		//From
		Select tmonth = new Select(driver.findElement(monthselectr));
		tmonth.selectByVisibleText("November");
		Select tyear = new Select(driver.findElement(yearselectr));
		tyear.selectByVisibleText("2021");
		
		List<WebElement> tdate = driver.findElements(dateselectr);
		for(int i=0;i<tdate.size();i++) {
			String tdatee = date.get(i).getText();
			//System.out.println(tdatee);
			if(tdatee.equalsIgnoreCase("30")) {
				if(date.get(i).isDisplayed()) {
					date.get(i).click();
					break;
				}
			}
		}
		Thread.sleep(3000);
		driver.findElement(select).click();
	}
	
	public void searchpatient() {
		driver.findElement(search).sendKeys("arul");
	}
	
	public void patientList() {
		List<WebElement> list = driver.findElements(patientlist);
		for(int i=0;i<list.size();i++) {
			String patlist = list.get(i).getText();
			System.out.println(patlist);
		}
		
		//Patient Completed the session
		System.out.println("\nCompleted Sessions\n");
		List<WebElement> complete = driver.findElements(patcompleted);
		for(int i=0;i<complete.size();i++) {
			String complist = complete.get(i).getText();
			System.out.println(complist);
		}
		
		//Patient Didn't Complete the session
		System.out.println("\nIncompleted Sessions\n");
		List<WebElement> incomplete = driver.findElements(patincompleted);
		for(int i=0;i<incomplete.size();i++) {
			String incomplist = incomplete.get(i).getText();
			System.out.println(incomplist);
		}
	}
	
	public void amountCal() {
		System.out.println("\nAmount Received\n");
		String str = null;
		List<WebElement> inr = driver.findElements(amount);
		for(int i=0;i<inr.size();i++) {
			String amount = inr.get(i).getText();
			str = amount.replaceAll("[^\\d]", " ");
			str = str.trim();
			str = str.replaceAll(" +", " ");
			System.out.println(str);
			int value=Integer.parseInt(str);
		}
		
	}
	
	public void reportExport() {
		WebElement report = driver.findElement(reportexport);
		if(report.isEnabled()) {
			report.click();
		}else{
			System.out.println("Export button is not Enabled.");
		}
	}
}
