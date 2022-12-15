package com.org.ss.virujh;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class StaticPages {

	WebDriver driver;
	
	public StaticPages(WebDriver driver) {
		this.driver=driver;
	}
	
	public void testcase1() throws InterruptedException {
		
		//Window screen size 1382, 754
		System.out.println(driver.manage().window().getSize());
	
		Dimension size = new Dimension(500, 600);
		driver.manage().window().setSize(size);
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scrollBy(0,6500)");
		Thread.sleep(5000);
		js.executeScript("scrollBy(0,-6500)");
		driver.manage().window().maximize();
		
		
		
		
		
	}
}
