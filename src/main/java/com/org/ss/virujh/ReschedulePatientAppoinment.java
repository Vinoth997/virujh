package com.org.ss.virujh;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReschedulePatientAppoinment {
	WebDriver driver;
	
	
	By appoinments    = By.xpath("//p[text()='Appointments']");
	By date		      = By.xpath("//p[contains(text(),'26 Feb, 2022 -05 Mar, 2022')]");
	By nextbtn        = By.xpath("//*[name()='svg' and @title='Next']");
	By previousbtn    = By.xpath("//*[name()='svg' and @title='Preveious']");
	By totalslots     = By.xpath("//div[contains(@style,'background')]");
	By blockedapoinmt = By.xpath("//div[@style='background-color: rgb(228, 245, 253);']");
	
	
	public ReschedulePatientAppoinment(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public void signin() throws InterruptedException {
		DoctorLogin dl = new DoctorLogin(driver);
		dl.login();
		dl.signIn();
	}
	
	public void appoinments() throws InterruptedException {
		WebElement appoinmnt = driver.findElement(appoinments);
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(appoinmnt));
		appoinmnt.click();
		
		//Total Slots
		List<WebElement> totalslot = driver.findElements(totalslots);
		System.out.println(totalslot.size());
		for(int i=0;i<totalslot.size();i++) {
			String clr = totalslot.get(i).getAttribute("style");
			if(clr.equalsIgnoreCase("background-color: rgb(228, 245, 253);")) {
				
				totalslot.get(i).click();
			}
		}
		
		WebElement dialodbx=driver.findElement(By.xpath("//div[@role='dialog']"));
		wait.until(ExpectedConditions.elementToBeClickable(dialodbx));
		dialodbx.click();
		Thread.sleep(3000);
		String title=driver.findElement(By.xpath("//div[contains(@class,'MuiDialogTitle')]//h5")).getText();
		System.out.println(title);
	}
	
	public void reschedule() {
		List<WebElement> reschdloption = driver.findElements(By.xpath("//p[contains(text(),'Direct')]//following::h5"));
		System.out.println(reschdloption.size());
		for(int i=0;i<reschdloption.size();i++) {
			String optnvalue = reschdloption.get(i).getText();
			System.out.println(optnvalue);
			if(optnvalue.equalsIgnoreCase("RESCHEDULE")) {
				reschdloption.get(i).click();
			}
		}
		driver.findElement(By.xpath("//input[@placeholder='DD/MM/YYYY']")).click();
		driver.findElement(By.xpath("//button//span[@class='MuiButton-label']//h6")).click();
		WebDriverWait wait = new WebDriverWait(driver,10);
		List<WebElement> year = driver.findElements(By.xpath("//div[@class='MuiPickersYearSelection-container']//div"));
		wait.until(ExpectedConditions.visibilityOfAllElements(year));
		for(int i=0;i<year.size();i++) {
			String yeartxt=year.get(i).getText();
			if(yeartxt.equalsIgnoreCase("2022")) {
				year.get(i).click();
				break;
			}
		}
		
		List<WebElement> month = driver.findElements(By.xpath("//div[contains(@class,'MuiPickersCalendarHeader')]//p"));
		for(int i=0;i<month.size();i++) {
			String monthtxt=month.get(i).getText();
			if(monthtxt.equalsIgnoreCase("January 2023")) {
				break;
			}else {
				driver.findElement(By.xpath("(//span//*[name()='svg'])[2]")).click();
			}
		}
		
		List<WebElement> date = driver.findElements(By.xpath("//div[@role='presentation']//button//span[@class='MuiIconButton-label']//p"));
	
		try
		{for(int i=0;i<date.size();i++) {
			String datetxt=date.get(i).getText();
			System.out.println(datetxt);
			if(datetxt.equals("11")) {
				//date.get(i).click();
				//wait.until(ExpectedConditions.elementToBeClickable(date.get(i)));
				date.get(i).click();
				//js.executeScript("arguments[0].click()",date.get(i));
			}
		}}catch(StaleElementReferenceException e) {
			//System.out.println(e);
		}
		
		driver.findElement(By.xpath("//button//span[text()='OK']")).click();		
		
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Due to some issue.");
		
		List<WebElement> timeslot = driver.findElements(By.xpath("//span[@class='MuiButton-label']//p"));
		for(int i=0;i<timeslot.size();i++) {
			String timeslttxt=timeslot.get(i).getText();
			if(timeslttxt.equals("4:30 PM")) {
				timeslot.get(i).click();
			}
		}
		
		driver.findElement(By.xpath("//p[text()='SUBMIT']")).click();
		WebElement dial=driver.findElement(By.xpath("//div[@class='MuiDialogContent-root']"));
		WebDriverWait wait2=new WebDriverWait(driver,10);
		wait2.until(ExpectedConditions.visibilityOf(dial));
		dial.click();
		String confirmation=driver.findElement(By.xpath("//div[@class='MuiDialogContent-root']//h5")).getText();
		System.out.println(confirmation);
		String confrmsg=driver.findElement(By.xpath("(//div[@class='MuiDialogContent-root']//p)[1]")).getText();
		System.out.println(confrmsg);
		driver.findElement(By.xpath("//p[text()='NO']")).click();
	}
	
	public void cancelappoinment() {
		List<WebElement> canceloption = driver.findElements(By.xpath("//p[contains(text(),'Direct')]//following::h5"));
		for(int i=0;i<canceloption.size();i++) {
			String optnvalue = canceloption.get(i).getText();
			System.out.println(optnvalue);
			if(optnvalue.equalsIgnoreCase("CANCEL")) {
				canceloption.get(i).click();
			}
		}
		
		String confrmmsg=driver.findElement(By.xpath("(//div[@class='MuiDialogContent-root']//p)[1]")).getText();
		System.out.println(confrmmsg);
		WebElement checkbox=driver.findElement(By.xpath("//input[@type='checkbox']"));
		if(checkbox.isEnabled()) {
			checkbox.click();
		}else {
			System.out.println("Checkbox Error");
		}
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Reason for Canceling the appoinment");
		driver.findElement(By.xpath("//p[text()='NO']")).click();
	}	
}
