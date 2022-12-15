package com.org.ss.virujh;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AttenderJoinMeeting {

	WebDriver driver;
	
	By login 		= By.xpath("//button[text()='Login']");
	By attenderjoin = By.xpath("//button//span[text()='Attender Join Meeting']");
	By meetingid    = By.xpath("//input[@name='meetingId']");
	By passcode     = By.xpath("//input[@name='passcode']");
	By eyebtn		= By.xpath("//*[name()='svg']");
	By join         = By.xpath("//button//span[text()='Join']");
	By cancel		= By.xpath("//button//span[text()='Cancel']");
	By okbtn		= By.xpath("//button//span[text()='OK']");
	
	public AttenderJoinMeeting(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scrollBy(0,400)");
		Thread.sleep(2000);
		driver.findElement(login).click();
		driver.findElement(attenderjoin).click();
	}
	
	public void withoutdata() {
		driver.findElement(join).click();
		
		List<WebElement> err = driver.findElements(By.xpath("//input//following::p"));
		for(int i=0;i<err.size();i++) {
			String errmsg = err.get(i).getText();
			System.out.println(errmsg);
		}
	}
	
	public void withoutpasscode() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(meetingid).sendKeys("VIRUJH-mb6gi");
		driver.findElement(join).click();
		String errmsg = driver.findElement(By.xpath("//input//following::p")).getText();
		System.out.println(errmsg);
	}
	
	public void withoutmeetingid() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(passcode).sendKeys("v35j29");
		driver.findElement(join).click();
		String errmsg = driver.findElement(By.xpath("//input//following::p")).getText();
		System.out.println(errmsg);
	}
	
	public void validmeetingidinvalidpasscode() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(meetingid).sendKeys("VIRUJH-mb6gi");
		driver.findElement(passcode).sendKeys("dummy");
		driver.findElement(eyebtn).click();
		driver.findElement(join).click();
		
		List<WebElement> err = driver.findElements(By.xpath("//div[@class='MuiDialogContent-root']//p"));
		for(int i=0;i<err.size();i++) {
			String errmsg = err.get(i).getText();
			System.out.println(errmsg);
		}
		Thread.sleep(2000);
		driver.findElement(okbtn).click();
	}
	
	public void invalidmeetingidvalidpasscode() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(meetingid).sendKeys("dummy");
		driver.findElement(passcode).sendKeys("v35j29");
		driver.findElement(eyebtn).click();
		driver.findElement(join).click();
		
		List<WebElement> err = driver.findElements(By.xpath("//div[@class='MuiDialogContent-root']//p"));
		for(int i=0;i<err.size();i++) {
			String errmsg = err.get(i).getText();
			System.out.println(errmsg);
		}
		Thread.sleep(2000);
		driver.findElement(okbtn).click();
		
	}
	
	public void invalidmeetinidinvalidpasscode() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(meetingid).sendKeys("dummy");
		driver.findElement(passcode).sendKeys("dummy");
		driver.findElement(eyebtn).click();
		driver.findElement(join).click();
		
		List<WebElement> err = driver.findElements(By.xpath("//div[@class='MuiDialogContent-root']//p"));
		for(int i=0;i<err.size();i++) {
			String errmsg = err.get(i).getText();
			System.out.println(errmsg);
		}
		Thread.sleep(2000);
		driver.findElement(okbtn).click();
		
	}
	
	public void validmeetingidvalidpasscode() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(meetingid).sendKeys("VIRUJH-mb6gi");
		driver.findElement(passcode).sendKeys("v35j29");
		driver.findElement(eyebtn).click();
		driver.findElement(join).click();
		
		List<WebElement> err = driver.findElements(By.xpath("//div[@class='MuiDialogContent-root']//p"));
		for(int i=0;i<err.size();i++) {
			String errmsg = err.get(i).getText();
			System.out.println(errmsg);
		}
		Thread.sleep(2000);
		driver.findElement(okbtn).click();
	}

	
}
