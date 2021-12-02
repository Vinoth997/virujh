package com.org.ss.virujh;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PatientForgotPassword {

	public WebDriver driver;
	
    By loginbutn    = By.xpath("(//button[@type=\"button\"])[2]");
    By patientbutn  = By.xpath("(//button[@type=\"button\"])[3]");
    By frgtpasswd   = By.xpath("//h4[contains(text(),'Forgot')]");
    By frgtpasswdf  = By.xpath("//div[@class='MuiPaper-root jss671 MuiPaper-outlined']");
    By phnum        = By.xpath("//input[@id='phone']");
    By restpswdbtn  = By.xpath("//button//span[contains(text(),'Reset Password')]");

    public PatientForgotPassword(WebDriver driver) {
  	  this.driver = driver;
    }
    
    public void patienttab() {
    	driver.findElement(loginbutn).click();
    	driver.findElement(patientbutn).click();
    }
    
    public void forgotpasswordfields() throws InterruptedException {
    	
    	driver.findElement(frgtpasswd).click();
    	//Thread.sleep(3000);
    	List<WebElement> fld = driver.findElements(By.tagName("p"));
    	for(WebElement text:fld) {
    		String lst=text.getText();
    		System.out.println(lst);
    	}
    }
    
    public void withoutnum() {
    	
    	driver.findElement(phnum).sendKeys("");
    	driver.findElement(restpswdbtn).click();
    	WebElement error=driver.findElement(By.xpath("//div//h6[contains(text(),'phone')]"));
    	String msg=error.getText();
    	if(!msg.isEmpty()) {
    		System.out.println(msg);
    	}else {
    		System.out.println("No Error msg displayed");
    	}
    }
    
    public void invalidnum() {
    	
    	driver.findElement(phnum).sendKeys("112");
    	driver.findElement(restpswdbtn).click();
    	WebElement error2=driver.findElement(By.xpath("//div//h6[contains(text(),'phone')]"));
    	String msg2=error2.getText();
    	if(!msg2.isEmpty()) {
    		System.out.println(msg2);
    	}else {
    		System.out.println("No Error msg displayed");
    	}
    }
    
    public void forgotPasswordfn() throws InterruptedException {
    	
    	//driver.findElement(phnum).clear();
    	WebElement toClear = driver.findElement(phnum);
    	toClear.sendKeys(Keys.CONTROL + "a");
    	toClear.sendKeys(Keys.DELETE);
    	driver.findElement(phnum).sendKeys("9876543222");
    	driver.findElement(restpswdbtn).click();
    	
    	try {
    	WebElement error3=driver.findElement(By.xpath("//p[@class='jss120']"));
    	String msg3=error3.getText();
    	if(!msg3.isEmpty()) {
    		System.out.println(msg3);
    	}else {
    		System.out.println("No msg displayed");
    	}}
    	catch(Exception e) {
    		System.out.println("Enter a valid registered number");
    	}
    }

}
