package com.org.ss.virujh;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Patientlogin {
public WebDriver driver;
	
	By loginbtn    = By.xpath("//button[contains(text(),'Login')]");
	By patientbtn  = By.xpath("//span[contains(text(),'Patient')]");
	By username	   = By.xpath("//input[@id='userName']");
	By password    = By.xpath("//input[@id='password']");
	By signinbtn   = By.xpath("//button//span[contains(text(),'Sign In')]");
	
	public Patientlogin(WebDriver driver) {
		this.driver=driver;
	}
	
	public void loginfn() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scrollBy(0,350)");
		
		Thread.sleep(3000);
		driver.findElement(loginbtn).click();
		driver.findElement(patientbtn).click();
		driver.findElement(username).sendKeys("9876543222");
		driver.findElement(password).sendKeys("Arulraj123#");
		driver.findElement(signinbtn).click();
	}

}
