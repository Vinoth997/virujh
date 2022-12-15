package com.org.ss.virujh;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DoctorHolidayList {
	
	public WebDriver driver;
	
	By appoinmenticon = By.xpath("//a[@href=\"/app/doctors\"]");
	By settings 	  = By.xpath("//button//span[text()='Settings']");
	By workschedule   = By.xpath("//p[text()='Work Schedules']");
	By holidaytitle   = By.xpath("//p[contains(@class,'header_txt')]");
	By addbtn		  = By.xpath("//button//span[text()='Add']");
	By fromdate 	  = By.xpath("(//img[@src=\"/app/static/media/newCalender.c15bce5d.svg\"])[1]");
	By yearbtn		  = By.xpath("//button/span/h6");
	By todate		  = By.xpath("(//img[@src=\"/app/static/media/newCalender.c15bce5d.svg\"])[2]");
	By year			  = By.xpath("//div[@role='button']");
	By month 		  = By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 MuiTypography-alignCenter']");
	By nextbtn		  = By.xpath("(//button[@class='MuiButtonBase-root MuiIconButton-root MuiPickersCalendarHeader-iconButton'])[2]");
	By previousbtn    = By.xpath("(//button[@class='MuiButtonBase-root MuiIconButton-root MuiPickersCalendarHeader-iconButton'])[1]");
	By date			  = By.xpath("//span[@class='MuiIconButton-label']//p");
	By okbtn          = By.xpath("//span[text()='OK']");
	By cancelbtn      = By.xpath("//span[text()='Cancel']");
	By description    = By.xpath("//input[contains(@placeholder,'as leave')]");
	By errortext      = By.xpath("//p[contains(@class,'errTxt')]");
	By closebtn		  = By.xpath("//button[@title=\"Close\"]");
	By save		      = By.xpath("//span[text()=' Save ']");
	By cancel         = By.xpath("//span[text()=' Cancel ']");
	By errortext2     = By.xpath("//div[@class='MuiDialogContent-root']/p");
	By updated        = By.xpath("//div[@role='alert']");
	By deletebtn	  = By.xpath("//tr[@class='MuiTableRow-root']//button");	 
	
	public DoctorHolidayList(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login_as_Doctor() throws InterruptedException {
		DoctorLogin dl = new DoctorLogin(driver);
		dl.login();
		dl.signIn();
	}
	
	public void work_schedule() {
		driver.findElement(settings).click();
		driver.findElement(workschedule).click();
	}
	
	public void title_validation() {
		String actualtitle = driver.findElement(holidaytitle).getText();
		String expectedtitle = "Holiday Lists";
		Assert.assertEquals(actualtitle, expectedtitle);
	}
	
	public void without_data() throws InterruptedException {
		driver.findElement(addbtn).click();
		driver.findElement(save).click();
		Thread.sleep(3000);
		List<WebElement> errormsg = driver.findElements(errortext);
		for(int i=0;i<errormsg.size();i++) {
			String errortxt=errormsg.get(i).getText();
			System.out.println(errortxt);
		}
		
		Thread.sleep(2000);
		driver.findElement(cancel).click();
	}
	
	public void holiday_from_date() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(addbtn).click();
		driver.findElement(fromdate).click();
		driver.findElement(yearbtn).click();
		Thread.sleep(3000);
		
		try {
			List<WebElement> yearselect = driver.findElements(year);
			for(int i=0;i<yearselect.size();i++) {
				String yeartxt=yearselect.get(i).getText();
				if(yeartxt.contains("2022")) {
					yearselect.get(i).click();
				}
			}
		}catch(StaleElementReferenceException e) {	
		}
	
		while (true) {
			String mnth = driver.findElement(month).getText();
			if (mnth.contains("April 2022")) {

				break;
			} else {
				driver.findElement(previousbtn).click();
			}
		}
		
		List<WebElement> dateselect = driver.findElements(date);
		for (WebElement datetext : dateselect) {
			if (datetext.getText().equals("7")) {
				datetext.click();
				break;
			}
		}
		Thread.sleep(2000);
		driver.findElement(okbtn).click();
		
	}
	
	public void holiday_to_date() throws InterruptedException {
		driver.findElement(todate).click();
		driver.findElement(yearbtn).click();
		Thread.sleep(3000);
		
		try {
			List<WebElement> yearselect = driver.findElements(year);
			for(int i=0;i<yearselect.size();i++) {
				String yeartxt=yearselect.get(i).getText();
				if(yeartxt.contains("2022")) {
					yearselect.get(i).click();
				}
			}
		}catch(StaleElementReferenceException e) {	
		}
	
		while (true) {
			String mnth = driver.findElement(month).getText();
			if (mnth.contains("April 2022")) {

				break;
			} else {
				driver.findElement(previousbtn).click();
			}
		}
		
		List<WebElement> dateselect = driver.findElements(date);
		for (WebElement datetext : dateselect) {
			if (datetext.getText().equals("10")) {
				datetext.click();
				break;
			}
		}
		Thread.sleep(2000);
		driver.findElement(okbtn).click();
	}
	
	public void add_description() throws InterruptedException {
		Thread.sleep(2000);
		WebElement desc = driver.findElement(description);
		if(desc.isEnabled()) {
			desc.sendKeys("Vacation");
		}else {
			System.out.println("Not enabled");
		}
	}
	
	public void save_holiday() throws InterruptedException {
		Thread.sleep(2000);
		WebElement cancelbtn = driver.findElement(cancel);
		WebElement savebt = driver.findElement(save);
		if(cancelbtn.isEnabled()) {
			savebt.click();
		}else {
			cancelbtn.click();
		}
	}
	
	public void updated_successfully() {
		WebElement success = driver.findElement(updated);
		if(success.isDisplayed()) {
			String msg = success.getText();
			System.out.println(msg);
		}else {
			driver.findElement(addbtn).click();
		}
	}
	
	public void existing_date() throws InterruptedException {
		Thread.sleep(5000);
		DoctorHolidayList dhl=new DoctorHolidayList(driver);
		dhl.holiday_from_date();
		dhl.holiday_to_date();
		dhl.add_description();
		dhl.save_holiday();
		Thread.sleep(3000);
		List<WebElement> errormsg1 = driver.findElements(errortext2);
		for(int i=0;i<errormsg1.size();i++) {
			String errortxt1=errormsg1.get(i).getText();
			System.out.println(errortxt1);
		}
		Thread.sleep(2000);
		driver.findElement(okbtn).click();
	}
	
	public void holiday_list() throws InterruptedException {
		Thread.sleep(3000);
		String list = driver.findElement(By.xpath("//tbody[@class=\"MuiTableBody-root tbl_body\"]/tr")).getText();
		System.out.println(list);
	}
	
	public void delete_holiday_list() throws InterruptedException {
		Thread.sleep(4000);
		WebElement holidaylist = driver.findElement(By.xpath("//p[text()=' Holiday Lists ']"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",holidaylist);
		Thread.sleep(2000);
		try {
			List<WebElement> list =  driver.findElements(By.xpath("//td[@class='MuiTableCell-root MuiTableCell-body MuiTableCell-alignLeft']"));
			for(int i=0;i<list.size();i++) {
				String listtext=list.get(i).getText();
				if(listtext.equalsIgnoreCase("Apr 07, 2022")) {
					WebElement dlt=driver.findElement(deletebtn);
					dlt.click();
				}else {
					break;
				}
			}}catch(NoSuchElementException e) {
				System.out.println(e);
			}
		
		Thread.sleep(3000);
		try
		{
			WebElement dltdialog = driver.findElement(By.xpath("//div[contains(@class,'cncl')]//p"));
			if(dltdialog.isDisplayed()) {
				String deletealert = dltdialog.getText();
				System.out.println(deletealert);
				WebElement deletebn = driver.findElement(By.xpath("//span[text()=' Delete ']"));
				deletebn.click();
			}else {
				return;
			}}catch(NoSuchElementException e) {
				System.out.println(e);
			}

	}
	
	public void vacation() throws InterruptedException {
		Thread.sleep(4000);
		WebElement holidaylist = driver.findElement(By.xpath("//p[text()=' Holiday Lists ']"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",holidaylist);
		String beforexpath = "(//tr[@class='MuiTableRow-root']//button)[";
		String afterxpath = "]";
		List<WebElement> vac = driver.findElements(By.xpath("//tr[@class='MuiTableRow-root']"));
		for(int i=0;i<vac.size();i++) {
			String actualxpath = beforexpath+i+afterxpath;
			System.out.println(actualxpath);
			String txt = vac.get(i).getText();
			System.out.println(txt);
			if(txt.contains("Trip")) {
				i=i+1;
				actualxpath = beforexpath+i+afterxpath;
				System.out.println(actualxpath);
				driver.findElement(By.xpath(actualxpath)).click();
			}
		}
		Thread.sleep(3000);
		try
		{
			WebElement dltdialog = driver.findElement(By.xpath("//div[contains(@class,'cncl')]//p"));
			if(dltdialog.isDisplayed()) {
				String deletealert = dltdialog.getText();
				System.out.println(deletealert);

				WebElement deletebn = driver.findElement(By.xpath("//span[text()=' Delete ']"));
				deletebn.click();
				String text = driver.findElement(By.xpath("//div[@class='MuiAlert-message']")).getText();
				System.out.println(text);
			}else {
				return;
			}}catch(NoSuchElementException e) {
				System.out.println(e);
			}
	}
	
	public void holiday_validation() {
		
	}
}
