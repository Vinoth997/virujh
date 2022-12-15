package com.org.ss.virujh;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DoctorCreatingAppoinment {

	WebDriver driver;	
	//Appoinment
	By appoinment = By.xpath("//span[contains(text(),'Appointments')]");
	
	//Logut
	By optionbtn = By.xpath("//div[@class=\"MuiBox-root jss100 jss73\"]");
	By logoutbtn = By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-outlined jss2026']");
	
	public DoctorCreatingAppoinment(WebDriver driver) {
		this.driver=driver;
	}
	
	public void loginfn() throws InterruptedException {
		DoctorLogin ds=new DoctorLogin(driver);
		ds.login();
		ds.signIn();
		
	}
	
	public void appoinmentfn() {
		//driver.findElement(appoinment).click();
		WebDriverWait wait=new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.elementToBeClickable(appoinment)).click();
	}
	
	public void freeslotcreateappoinment() throws InterruptedException {
	
		List<WebElement> freeslots=driver.findElements(By.xpath("//p[contains(text(),'FREE SLOT')]"));
		System.out.println("Total Free slots Available : "+freeslots.size());
		Thread.sleep(3000);
		
		boolean check = driver.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1']")).isSelected();
		System.out.println(check);
		
		WebElement freeslot = driver.findElement(By.xpath("(//p[contains(text(),'FREE SLOT')])[1]"));
		boolean freeslt = freeslot.isEnabled();
		System.out.println("Free Slots enabled : "+freeslt);
		freeslot.click();
		
		WebElement textarea = driver.findElement(By.xpath("//input[@type='text']"));
		boolean txtarea = textarea.isEnabled();	
		System.out.println("Textarea is enabled :"+ txtarea);
		
		WebElement nxtbtn = driver.findElement(By.xpath("//p[contains(text(),'NEXT')]"));
		//Passing Empty data and click Next
		textarea.sendKeys("");
		nxtbtn.click();
		Thread.sleep(3000);
		String err1 = driver.findElement(By.xpath("(//input[@type='text']/following::p)[1]")).getText();
		System.out.println(err1);
		
		//Passing Invalid data no and click Next
		textarea.sendKeys("22222");
		nxtbtn.click();
		Thread.sleep(3000);
		String err2 = driver.findElement(By.xpath("(//input[@type='text']/following::p)")).getText();
		System.out.println(err2);
		
		//Passing Valid data and click Next
		textarea.sendKeys("2222222222");
		nxtbtn.click();
				
		//driver.findElement(By.xpath("//*[name()='svg' and @title='Close']")).click();
		Thread.sleep(3000);
	}
	
	public void createAppoinment() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@class='flag in']")).click();
//		String country=driver.findElement(By.xpath("//ul[@class=' country-list']")).getText();
//		System.out.println(country);
		
		List<WebElement> country = driver.findElements(By.xpath("//li[@class='country']"));
		//Thread.sleep(3000);
		for (int i = 0; i < country.size(); i++) {
			String data = country.get(i).getText();
			if (data.equalsIgnoreCase("Monaco+377")) {
				country.get(i).click();
				break;
			}
		}
		
		WebElement fname=driver.findElement(By.xpath("//input[@name='First Name']"));
		WebElement lname=driver.findElement(By.xpath("//input[@name='Last Name']"));
		WebElement email=driver.findElement(By.xpath("//input[@name='email']"));
		fname.sendKeys("aaaaaa");
		lname.sendKeys("bbbbbb");
		email.sendKeys("mailmail");
		
		driver.findElement(By.xpath("//input[@placeholder='DD/MM/YYYY']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='MuiButton-label']//h6")).click();
		List<WebElement> year = driver.findElements(By.xpath("//div[@class='MuiPickersYearSelection-container']//div"));
		for (int i = 0; i < year.size(); i++) {
			String data1 = year.get(i).getText();
			if (data1.equalsIgnoreCase("1996")) {
				year.get(i).click();
				break;
			}
		}
		
	
		while(true) {
			String mnth = driver.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 MuiTypography-alignCenter']")).getText();
			if(mnth.equalsIgnoreCase("April 1996")) {
				break;
			}else {
				driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
			}
		}
	
	List<WebElement> date = driver.findElements(By.xpath("//span[@class='MuiIconButton-label']//p"));
	for(int i = 0; i< date.size(); i++) {
		String data2 = date.get(i).getText();
		if(data2.equalsIgnoreCase("2")) {
			date.get(i).click();
			break;
		}
	}
	
	driver.findElement(By.xpath("//span[contains(text(),'OK')]")).click();
	driver.findElement(By.xpath("(//div[@role='button'])[3]")).click();
	List<WebElement> payopt = driver.findElements(By.xpath("//li[@role='option']"));
	for(int i = 0; i<payopt.size(); i++) {
		String data3 = payopt.get(i).getText();
		System.out.println(data3);
		if(data3.equalsIgnoreCase("Not Required")) {
			payopt.get(i).click();
			break;
		}
	}
		driver.findElement(By.xpath("(//div[@role='button'])[4]")).click();
		List<WebElement> conslt = driver.findElements(By.xpath("//li[@role='option']"));
		for(int i = 0; i<conslt.size(); i++) {
			String data4 = payopt.get(i).getText();
			System.out.println(data4);
			if(data4.equalsIgnoreCase("In Hospital")) {
				conslt.get(i).click();
				break;
			}
     	
		}
	
	}
	
	
		
	public void availabledate() {
//		List<WebElement> mnth=driver.findElements(By.xpath("//p[contains(text(),'')]"));
//		int total=mnth.size();
//		System.out.println(total);
//		for(int i=0;i<total;i++) {
//			String mnthyr=mnth.get(i).getText();
//			if(mnthyr.equals("JANUARY, 2022")) {
//				break;
//			}
//			else {
//				driver.findElement(By.xpath("//*[name()='svg'and@title='Next']")).click();
//				 }
//		 }
		
		try {
		while (true) {
			String mnth = driver.findElement(By.xpath("//p[contains(text(),'')]")).getText();
			
			if (mnth.equalsIgnoreCase("JANUARY, 2022")) {

				break;
			}else if(mnth.equalsIgnoreCase("JANUARY, 2022")) {
				driver.findElement(By.xpath("//*[name()='svg'and@title='Next']")).click();
			}else {
				driver.findElement(By.xpath("//*[name()='svg'and@title='Next']")).click();
			}
		}}
		catch(NoSuchElementException e) {
			System.out.println(e);
		}
		
		
	 }
		/*WebElement booked=driver.findElement(By.xpath("(//div[@class='MuiBox-root jss206 jss194']//p)[1]"));
		if(booked.getText().equalsIgnoreCase("NOVEMBER, 2021"))
		{
			List<WebElement> booking=driver.findElements(By.xpath("//p[contains(text(),'Mr. Arul')]"));
			System.out.println("Total Free slots Available : "+booking.size());
		}else {
			//driver.findElement(By.xpath("//*[name()='svg' and @title='Next']")).click();
			WebDriverWait wait1=new WebDriverWait(driver,30);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[name()='svg' and @title='Next']"))).click();
		}
	}*/

	public void logoutfn() throws InterruptedException {
		Thread.sleep(3000);
		//driver.findElement(optionbtn).click();
		//driver.findElement(logoutbtn).click();
	}

	


}
