package com.org.ss.virujh;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.org.ss.virujh.DoctorLogin;

public class DoctorChangePassword {
	WebDriver driver;
	
	By profilebtn        = By.xpath("//img[@alt='hospital logo']");
	By changepasswrd     = By.xpath("//p[text()='Change Password']");
	By title             = By.xpath("//div[contains(text(),'Change')]");
	By labels            = By.xpath("//div[@class='txt-label-wrap']//label");
	By currentpasswrd    = By.xpath("//input[@name='oldPassword']");
	By currentpasswrdchk = By.xpath("(//button[contains(@class,'pass-rvl-btn')])[1]");
	By newpasswrd        = By.xpath("//input[@name='newPassword']");
	By newpasswrdchk     = By.xpath("(//button[contains(@class,'pass-rvl-btn')])[2]");
	By confrmpasswrd     = By.xpath("//input[@name='confirmNewPassword']");
	By confrmpasswrdchk  = By.xpath("(//button[contains(@class,'pass-rvl-btn')])[3]");
	By savebtn			 = By.xpath("//span[text()='Save']");
	
	public DoctorChangePassword(WebDriver driver) {
		this.driver=driver;
	}
	
	public void login() throws InterruptedException {
		DoctorLogin dl = new DoctorLogin(driver);
		dl.login();
		dl.signIn();
	}
	
	public void changepassword() {
		driver.findElement(profilebtn).click();
		driver.findElement(changepasswrd).click();
//		String expected = "Change Password";
//		String actual = driver.findElement(title).getText();
//		assertEquals(actual, expected);
//		List<WebElement> labels = driver.findElements(By.xpath("//div[@class='txt-label-wrap']//label"));
//		for(WebElement labl:labels) {
//			String txt=labl.getText();
//			System.out.println(txt);
//		}
	}
	
	public void withoutdata() throws InterruptedException {
		driver.findElement(currentpasswrd).sendKeys("");
		driver.findElement(currentpasswrdchk).click();
		driver.findElement(confrmpasswrd).sendKeys("");
		driver.findElement(confrmpasswrdchk).click();
		driver.findElement(newpasswrd).sendKeys("");
		driver.findElement(confrmpasswrdchk).click();
		driver.findElement(savebtn).click();
		Thread.sleep(3000);
		List<WebElement> errmsg = driver.findElements(By.xpath("//label[@class='txt-field-error err-msg']"));
		for(int i=0;i<errmsg.size();i++) {
			String err = errmsg.get(i).getText();
			System.out.println(err);
		}
	}
	
	public void invalidnewpassword() throws InterruptedException {
		driver.findElement(currentpasswrd).sendKeys("Adsgdgd1!");
		driver.findElement(currentpasswrdchk).click();
		driver.findElement(newpasswrd).sendKeys("asdadsa");
		driver.findElement(newpasswrdchk).click();
		driver.findElement(confrmpasswrd).sendKeys("asdadsa");
		driver.findElement(confrmpasswrdchk).click();
		driver.findElement(savebtn).click();
		Thread.sleep(3000);
		String errmsg = driver.findElement(By.xpath("//label[@class='txt-field-error err-msg']")).getText();
		System.out.println(errmsg);
	}
	
	public void invalidconfirmpassword() throws InterruptedException {
		driver.findElement(currentpasswrd).sendKeys("Adsgdgd1!");
		driver.findElement(currentpasswrdchk).click();
		driver.findElement(newpasswrd).sendKeys("Adsgdgd1!");
		driver.findElement(newpasswrdchk).click();
		driver.findElement(confrmpasswrd).sendKeys("Adsgdgd1");
		driver.findElement(confrmpasswrdchk).click();
		driver.findElement(savebtn).click();
		Thread.sleep(3000);
		List<WebElement> errmsg = driver.findElements(By.xpath("//label[@class='txt-field-error err-msg']"));
		for(int i=0;i<errmsg.size();i++) {
			String err = errmsg.get(i).getText();
			System.out.println(err);
		}
	}
	
	public void invalidmaxlenght() throws InterruptedException {
		driver.findElement(currentpasswrd).sendKeys("Adsgdgd1!");
		driver.findElement(currentpasswrdchk).click();
		driver.findElement(newpasswrd).sendKeys("asdadsa1fghgfhgfh");
		driver.findElement(newpasswrdchk).click();
		driver.findElement(confrmpasswrd).sendKeys("asdadsa");
		driver.findElement(confrmpasswrdchk).click();
		driver.findElement(savebtn).click();
		Thread.sleep(3000);
		String errmsg = driver.findElement(By.xpath("//label[@class='txt-field-error err-msg']")).getText();
		System.out.println(errmsg);
	}
	
	public void invalidminlength() throws InterruptedException {
		driver.findElement(currentpasswrd).sendKeys("Adsgdgd1!");
		driver.findElement(currentpasswrdchk).click();
		driver.findElement(newpasswrd).sendKeys("ad");
		driver.findElement(newpasswrdchk).click();
		driver.findElement(confrmpasswrd).sendKeys("a");
		driver.findElement(confrmpasswrdchk).click();
		driver.findElement(savebtn).click();
		Thread.sleep(3000);
		String errmsg = driver.findElement(By.xpath("//label[@class='txt-field-error err-msg']")).getText();
		System.out.println(errmsg);
	}
	
	public void givingSamecurrentpassToNewpass() throws InterruptedException {
		driver.findElement(currentpasswrd).sendKeys("Vinoth123");
		driver.findElement(currentpasswrdchk).click();
		driver.findElement(newpasswrd).sendKeys("Vinoth123");
		driver.findElement(newpasswrdchk).click();
		driver.findElement(confrmpasswrd).sendKeys("Vinoth123");
		driver.findElement(confrmpasswrdchk).click();
		driver.findElement(savebtn).click();
		Thread.sleep(3000);
		List<WebElement> errmsg = driver.findElements(By.xpath("//label[@class='txt-field-error err-msg']"));
		for(int i=0;i<errmsg.size();i++) {
			String err = errmsg.get(i).getText();
			System.out.println(err);
		}
	}
	
	public void invalidcurrentpassword() throws InterruptedException {
		driver.findElement(currentpasswrd).sendKeys("Vinoth123#");
		driver.findElement(currentpasswrdchk).click();
		driver.findElement(newpasswrd).sendKeys("Vinoth123");
		driver.findElement(newpasswrdchk).click();
		driver.findElement(confrmpasswrd).sendKeys("Vinoth123");
		driver.findElement(confrmpasswrdchk).click();
		driver.findElement(savebtn).click();
		Thread.sleep(3000);
		List<WebElement> errmsg = driver.findElements(By.xpath("//div[@class='MuiDialogContent-root']//p"));
		for(int i=0;i<errmsg.size();i++) {
			String err = errmsg.get(i).getText();
			System.out.println(err);
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button//span[contains(text(),'OK')]")).click();
	}
}
