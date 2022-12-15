package com.org.ss.virujh;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage {
	WebDriver driver;
	
	By store     = By.xpath("//a[@class='app-btn']");
	By appstore  = By.xpath("(//a[@class='app-btn'])[1]");
	By playstore = By.xpath("(//a[@class='app-btn'])[2]");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void checkinglinks() {
		List<WebElement> link = driver.findElements(store);
		System.out.println("Total links : "+link.size());
		List<WebElement> activelink = new ArrayList<WebElement>();
		for(int i=0;i<link.size();i++) {
			if(link.get(i).getAttribute("href") != null) {
				activelink.add(link.get(i));
			}
			System.out.println("link : "+activelink.size()+" "+activelink.get(i).getAttribute("href"));
		}	
	}
	
	public void appstore() throws InterruptedException {
		String expected = "Virujh 17+";
		driver.findElement(appstore).click();
		String actual = driver.findElement(By.xpath("//h1[contains(@class,'header')]")).getText();
		Assert.assertEquals(actual, expected);
		driver.findElement(By.xpath("//picture[@id='ember32']")).click();
		driver.findElement(By.xpath("//a[@id='ember31']")).click();
		driver.findElement(By.xpath("//a[@id='ember30']")).click();
		WebElement scroll = driver.findElement(By.xpath("(//p[@dir='ltr'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Thread.sleep(4000);
		js.executeScript("arguments[0].scrollIntoView();",scroll);
		List<WebElement> compdevice = driver.findElements(By.xpath("//dt[@class='information-list__item__definition__item__term']"));
		for(WebElement device : compdevice) {
			String dev = device.getText();
			System.out.println("Supports : "+dev);
		}
		
	}
	
	public void playstore() throws InterruptedException {
		
		String expected = "Virujh";
		driver.findElement(playstore).click();
		String actual = driver.findElement(By.xpath("//h1[@class='AHFaub']")).getText();
		Assert.assertEquals(actual, expected);
		driver.findElement(By.xpath("//button[@class='Q4vdJd']")).click();
		driver.findElement(By.xpath("//div[@class='XjBJk']")).click();
		driver.findElement(By.xpath("//span[@class='oocvOe']//button")).click();
		String expect = "Please sign in";
		String actul = driver.findElement(By.xpath("//div[@role='heading']")).getText();
		Assert.assertEquals(actul, expect);
		//driver.findElement(By.xpath("(//button[text()='Cancel'])[2]")).click();
		driver.findElement(By.xpath("(//button[text()='Sign in'])[2]")).click();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("sampletest@gmail.com");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		//WebElement tryagain = driver.findElement(By.xpath("//button[@type='button']"));
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.elementToBeClickable(tryagain)).click();
		//JavascriptExecutor js =(JavascriptExecutor)driver;
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']")).click();

	}
}
