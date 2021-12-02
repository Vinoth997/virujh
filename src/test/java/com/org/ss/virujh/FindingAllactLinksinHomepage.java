package com.org.ss.virujh;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindingAllactLinksinHomepage {
	
	public static void main(String[] args) throws MalformedURLException, IOException {	
		
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev.virujh.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Total no. of links present
		List<WebElement> alllinks = driver.findElements(By.tagName("a"));
		//int count = alllinks.size();
		System.out.println("\nTotal No. of Links : "+alllinks.size()+"\n");
		
		//Total no. of active links
		List<WebElement> activelink = new ArrayList<WebElement>();
		
		for(int i=0;i<alllinks.size();i++) {
			if(alllinks.get(i).getAttribute("href") != null){
				activelink.add(alllinks.get(i));
			}
		}
		
		System.out.println("Total No. of Activelinks : "+activelink.size()+"\n");
		
		//Print the active links present
		for(int j=0;j<activelink.size();j++) {
			HttpsURLConnection connection = (HttpsURLConnection)new URL(activelink.get(j).getAttribute("href")).openConnection();
			connection.connect();
			String response = connection.getResponseMessage();
			connection.disconnect();
			
			System.out.println(activelink.get(j).getAttribute("href")+"------> "+response );
		}
	  driver.close();
	}

}
