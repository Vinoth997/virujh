package com.org.ss.virujh;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DoctorHolidayValidation {
	
	public WebDriver driver;
	
	By holiday = By.xpath("//div[@style='background-color: rgb(247, 220, 224);']");
	By nextbtn = By.xpath("//*[name()='svg' and @title='Next']");
	By prevbtn = By.xpath("//*[name()='svg' and @title='Preveious']");
	By month   = By.xpath("(//p[contains(@class,'MuiTypography-root MuiTypography-body1')]//preceding::p)[6]");
	
	public DoctorHolidayValidation(WebDriver driver) {
		this.driver = driver;
	}
	
	public void doctor_login() throws InterruptedException {
		DoctorLogin dl = new DoctorLogin(driver);
		dl.login();
		dl.signIn();
	}
	
	public void appoinments() {
		DoctorCreatingAppoinment dc = new DoctorCreatingAppoinment(driver);
		dc.appoinmentfn();
	}
	
	public void holiday_btn() throws InterruptedException {
		Thread.sleep(3000);
		WebElement holidaybtn = driver.findElement(holiday);
		holidaybtn.click();
		if(holidaybtn.isSelected()) {
			System.out.println("The button is working");
		}else {
			System.out.println("The button is not working");
		}
	}
	
	public void holiday_list() throws InterruptedException {
//		List<WebElement> list = driver.findElements(holiday);
//		for(int i=0;i<list.size();i++) {
//			String holidaylist = list.get(i).getText();
//		}
		
		
		
		WebElement monthlist = driver.findElement(month);
		WebElement nextbutton = driver.findElement(nextbtn);
		WebElement prevbutton = driver.findElement(prevbtn);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String holidaylist = null;
		String monthn = null;
		while (true) {
			String mnth = monthlist.getText();
			if (mnth.equals("MARCH, 2022")) {
				break;
			} else {
				List<WebElement> list = driver.findElements(holiday);
				for(int i=0;i<list.size();i++) {
					holidaylist = list.get(i).getText();
					monthn = monthlist.getText();
				}
				System.out.println(monthn +":" + list.size());
				//System.out.println(list.size());
				
				wait.until(ExpectedConditions.elementToBeClickable(nextbutton));
				Thread.sleep(2000);
				nextbutton.click();
			}
		}
		prevbutton.click();
	}
}
