package com.org.ss.virujh;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PatientChangePassword {
	
	WebDriver driver;
	
	By profilebtn         = By.xpath("//span[text()='FIND DOCTOR / BOOK APPOINTMENT']/following::div//div");
	By changepswd         = By.xpath("//p[text()='Change Password']");
	By label              = By.xpath("//label");
	By currentpswd        = By.xpath("//input[@name='oldPassword']");
	By currentpswdeyebtn  = By.xpath("(//input[@name='oldPassword']//following::button)[1]");
	By newpswd            = By.xpath("//input[@name='newPassword']");
	By newpswdeyebtn	  = By.xpath("//input[@name='newPassword']//following::button");
	By confirmnewpswd 	  = By.xpath("//input[@name='confirmNewPassword']");
	By confirmpswdeyebtn  = By.xpath("//input[@name='confirmNewPassword']//following::button");
	By savebtn			  = By.xpath("//button//span[text()='Save']");
	By closebtn			  = By.xpath("//*[name()='svg' and @title='Close']");
	By logout			  = By.xpath("//p[text()='Logout']");
	
	public PatientChangePassword(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login() throws InterruptedException {
		Patientlogin pl = new Patientlogin(driver);
		pl.loginfn();
	}
	
	public void changePasswordfn() throws InterruptedException {
		boolean dis = driver.findElement(profilebtn).isDisplayed();
		boolean en = driver.findElement(profilebtn).isEnabled();
		System.out.println("Profile button is displayed : "+dis);
		System.out.println("Profile button is enebled : "+en);
		
		Thread.sleep(3000);
		driver.findElement(profilebtn).click();
		
		
		String st = driver.findElement(By.xpath("//p[@class='MuiTypography-root jss92 MuiTypography-body1']")).getText();
		System.out.println(st);
		List<WebElement> opt = driver.findElements(By.xpath("//p[@class='MuiTypography-root jss91 MuiTypography-body1']"));
		int opti = opt.size();
		for(int i=0;i<opti;i++) {
			String option = opt.get(i).getText();
			System.out.println(option);
			
		}
//		for(WebElement opti:opt) {
//			String option=opti.getText();
//			System.out.println(option);
//		}
		
		driver.findElement(changepswd).click();
		
		List<WebElement> label = driver.findElements(By.xpath("//label"));
		int lb = label.size();
		for(int i=0;i<lb;i++) {
			String labels = label.get(i).getText();
			System.out.println(labels);
		}
		
		driver.findElement(savebtn).click();
		List<WebElement> err = driver.findElements(By.xpath("//label[@class='txt-field-error err-msg']"));
		for(WebElement errr:err) {
			String msg = errr.getText();
			System.out.println(msg);
		}
		
		driver.findElement(currentpswd).sendKeys("ccxzCXxzc");
		//driver.findElement(currentpswdeyebtn).click();
		driver.findElement(newpswd).sendKeys("sadasdd");
		//driver.findElement(newpswdeyebtn).click();
		driver.findElement(savebtn).click();
		String err1 = driver.findElement(By.xpath("(//label[@class='txt-field-error err-msg'])[1]")).getText();
		System.out.println(err1);
		
		driver.findElement(currentpswd).clear();
		driver.findElement(newpswd).clear();
		
		
		driver.findElement(currentpswd).sendKeys("Vinoth123#");
		driver.findElement(newpswd).sendKeys("Vinoth1234");
		driver.findElement(confirmnewpswd).sendKeys("Vinoth123");
		driver.findElement(savebtn).click();
		String err2=driver.findElement(By.xpath("//label[@class='txt-field-error err-msg']")).getText();
		System.out.println(err2);
		
		driver.findElement(currentpswd).clear();
		driver.findElement(newpswd).clear();
		driver.findElement(confirmnewpswd).clear();
		
		driver.findElement(currentpswd).sendKeys("Vinoth123");
		driver.findElement(newpswd).sendKeys("Vinoth1234");
		driver.findElement(confirmnewpswd).sendKeys("Vinoth1234");
		driver.findElement(savebtn).click();
		
		List<WebElement> err3 = driver.findElements(By.xpath("//div[@class='MuiDialogContent-root']//p"));
		for(WebElement errr:err3) {
			String text=errr.getText();
			System.out.println(text);
		}
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[text()='OK']")).click();
		
		
		driver.findElement(profilebtn).click();
		boolean disp = driver.findElement(logout).isDisplayed();
		boolean enab = driver.findElement(logout).isEnabled();
		System.out.println("Logout button is displayed : "+disp);
		System.out.println("Logout button is enabled : "+enab);
		driver.findElement(logout).click();
		
		driver.findElement(By.xpath(""));
	}
}
