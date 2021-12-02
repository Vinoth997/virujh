package com.org.ss.virujh;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser 
{
 public  WebDriver driver;
	
	public  WebDriver browseropen(){
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev.virujh.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	} 
}
