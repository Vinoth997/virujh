package com.org.ss.virujh;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DoctorLoginCredential {

	WebDriver driver;	
	
	By login         = By.xpath("//button[text()='Login']");
	By docbtn        = By.xpath("//button//span[text()='Doctor']");
	By username      = By.xpath("//input[@id='userName']");
	By passwrd       = By.xpath("//input[@id='password']");
	By passwrdeyebtn = By.xpath("//*[name()='svg']");
	By signin        = By.xpath("//span[text()='Sign In']");
	
	public DoctorLoginCredential(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login() throws InterruptedException {
		//WebElement loginbtn = driver.findElement(login);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scrollBy(0,320)");
		//js.executeScript("arguments[0].scrollIntoView(true);",loginbtn);
		Thread.sleep(2000);
		driver.findElement(login).click();
		driver.findElement(docbtn).click();
	}

	public void signIn() throws InterruptedException {
		driver.findElement(username).sendKeys("vinothkumar.c@softsuave.com");
		driver.findElement(passwrd).sendKeys("Vinoth123#");
		driver.findElement(passwrdeyebtn).click();
		Thread.sleep(2000);
		driver.findElement(passwrdeyebtn).click();
		driver.findElement(signin).click();
	}

	public void signInwithoutdata() throws InterruptedException {
		driver.findElement(signin).click();
		List<WebElement> msg1 = driver.findElements(By.xpath("//h6[contains(@class,'jss17')]"));
		for(WebElement txt1 : msg1) {
			String text = txt1.getText();
			System.out.println(text);
		}
		
	}
	
	public void signInwithoutpasswrd() throws InterruptedException {
//		To Highlight the element
//		WebElement tx = driver.findElement(By.xpath("//p[@class='MuiTypography-root jss40 MuiTypography-body1']"));
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].style.border='2px dotted red'",tx);
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(username).sendKeys("samplemail@gmail.com");
		driver.findElement(signin).click();
		String txt = driver.findElement(By.xpath("//h6[contains(@class,'jss17')]")).getText();
		System.out.println(txt);
	}
	
	public void signInwithoutmail() {
		driver.navigate().refresh();
		driver.findElement(passwrd).sendKeys("Abcd111#");
		driver.findElement(signin).click();
		String txt = driver.findElement(By.xpath("//h6[contains(@class,'jss17')]")).getText();
		System.out.println(txt);
	}
	
	public void signinInvalidpassword() {
		driver.navigate().refresh();
		driver.findElement(username).sendKeys("samlemail@gmail.com");
		driver.findElement(passwrd).sendKeys("qweqwewq");
		driver.findElement(passwrdeyebtn).click();
		driver.findElement(signin).click();
		String txt = driver.findElement(By.xpath("//h6[contains(@class,'jss17')]")).getText();
		System.out.println(txt);
	}
	
	public void signinInvalidmail() {
		driver.navigate().refresh();
		driver.findElement(username).sendKeys("samplemail@gmail");
		driver.findElement(passwrd).sendKeys("Abcd12#");
		driver.findElement(passwrdeyebtn).click();
		driver.findElement(signin).click();
		String txt = driver.findElement(By.xpath("//h6[contains(@class,'jss17')]")).getText();
		System.out.println(txt);
		driver.navigate().refresh();
	}
	
}
