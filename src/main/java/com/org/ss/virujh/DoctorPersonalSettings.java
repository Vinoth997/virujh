package com.org.ss.virujh;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DoctorPersonalSettings {
	
	WebDriver driver;
	
	By docicon    = By.xpath("//i[@title='Appointments']");
	By settings   = By.xpath("//span[text()='Settings']");
	By docpsnlset = By.partialLinkText("Personal Setting");
	By totlfields = By.xpath("//p[contains(@class,'jss189') or contains(@class,'jss265')]");
	By mandfields = By.xpath("//p[contains(@class,'required-field')]");
	By uploadpic  = By.xpath("//*[name()='svg' and @class='MuiSvgIcon-root']");
	
	public DoctorPersonalSettings(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login() throws InterruptedException {
		DoctorLogin dl = new DoctorLogin(driver);
		dl.login();
		dl.signIn();
	}
	
	public void settings() {
		driver.findElement(docicon).click();
		driver.findElement(settings).click();
	}
	
	public void doctorpersonalsettings() throws InterruptedException {
		driver.findElement(docpsnlset).isDisplayed();
		driver.findElement(docpsnlset).isEnabled();
		driver.findElement(docpsnlset).click();
		
		int tt = driver.findElements(totlfields).size();
		System.out.println("Total fields : "+tt);
		
		List<WebElement> totalfields = driver.findElements(totlfields);
		for(WebElement tfld : totalfields) {
			String tot = tfld.getText();
			System.out.println(tot);
		}
		
		int rt =driver.findElements(mandfields).size();
		System.out.println("Mandatory fields : "+rt);
		
		List<WebElement> mandfilds = driver.findElements(mandfields);
		for(WebElement mdfild:mandfilds) {
			String tot = mdfild.getText();
			System.out.println(tot);
		}
		
		//pic Upload 
		driver.findElement(By.xpath("(//input[@type='file'])[1]")).sendKeys("D:\\Picture\\Image.jpg");
	    String tx = driver.findElement(By.xpath("//div[@class='MuiAlert-message']")).getText();
	    System.out.println(tx);
	    
	    //First Name
		driver.findElement(By.xpath("(//button)[2]")).click();
		WebElement firstname = driver.findElement(By.xpath("//input[@name='firstName']"));
		Thread.sleep(2000);
		if(firstname.isEnabled()) {
			driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
			String alrt = driver.findElement(By.xpath("//div[@class='MuiAlert-message']")).getText();
			System.out.println(alrt);
			driver.findElement(By.xpath("//button[@title='Close']")).click();
		}else {
			System.out.println("First Name not Enabled");
		}
		Thread.sleep(3000);
		
		
		
		//Last Name
		driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
		WebElement lastname = driver.findElement(By.xpath("//input[@name='lastName']"));
		Thread.sleep(2000);
		if(lastname.isEnabled()) {
			driver.findElement(By.xpath("(//button[@type='button'])[8]")).click();
		}else {
			System.out.println("Last Name not Enabled");
		}
		Thread.sleep(3000);
		
		//Contact Number
		driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
		WebElement number = driver.findElement(By.xpath("//input[@name='number']"));
		Thread.sleep(2000);
		if(number.isEnabled()) {
			driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
		}else {
			System.out.println("Contact Number not Enabled");
		}
		Thread.sleep(3000);
		
		//Specialization
		driver.findElement(By.xpath("(//button[@type='button'])[8]")).click();
		WebElement spec = driver.findElement(By.xpath("//input[@name='speciality']"));
		Thread.sleep(2000);
		if(spec.isEnabled()) {
			//spec.click();
			//spec.clear();
			spec.sendKeys("1");
			driver.findElement(By.xpath("(//button[@type='button'])[9]")).click();
		}else {
			System.out.println("Specialization not Enbled");
		}
		Thread.sleep(3000);
		
		//Qualification
		driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
		WebElement qual = driver.findElement(By.xpath("//input[@name='qualification']"));
		Thread.sleep(2000);
		if(qual.isEnabled()) {
			driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
		}else {
			System.out.println("Qualification not enabled");
		}
		Thread.sleep(3000);
		
		//Years of Experience
		driver.findElement(By.xpath("(//button[@type='button'])[9]")).click();
		WebElement yrsexp = driver.findElement(By.xpath("//input[@name='experience']"));
		Thread.sleep(2000);
		if(yrsexp.isEnabled()) {
			driver.findElement(By.xpath("(//button[@type='button'])[10]")).click();
		}else {
			System.out.println("Years of Exp not Enabled");
		}
		Thread.sleep(3000);
		
		//Primary Language
		driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
		WebElement prmlang = driver.findElement(By.xpath("//input[@name='primaryLanguages']"));
		Thread.sleep(2000);
		if(prmlang.isEnabled()) {
			driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
		}else {
			System.out.println("Primary Language not Enabled");
		}
		Thread.sleep(3000);
		
		//Secondary Language
		driver.findElement(By.xpath("(//button[@type='button'])[10]")).click();
		WebElement seclang = driver.findElement(By.xpath("//input[@name='secondaryLanguages']"));
		Thread.sleep(2000);
		if(seclang.isEnabled()) {
			driver.findElement(By.xpath("(//button[@type='button'])[11]")).click();
		}else {
			System.out.println("Secondary Language not Enabled");
		}
		Thread.sleep(3000);
		
		//Report Remainder
		driver.findElement(By.xpath("(//div[@role='button'])[1]")).click();
		WebElement remaindr = driver.findElement(By.xpath("//input[@name='reportRemainder']"));
		Thread.sleep(2000);
		if(remaindr.isEnabled()) {
		List<WebElement> opt1 = driver.findElements(By.xpath("//li"));
		for(int i=0;i<opt1.size();i++) {
			String data1 = opt1.get(i).getText();
			if(data1.equals("Once a Day")) {
				opt1.get(i).click();
				break;
			}
		}
		driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
		}else {
			System.out.println("Report Remainder not Enabled");
		}
		Thread.sleep(3000);
		
		//Time Zone
		driver.findElement(By.xpath("(//div[@role='button'])[2]")).click();
		WebElement time = driver.findElement(By.xpath("//input[@name='timeZone']"));
		Thread.sleep(2000);
		if(time.isEnabled()) {
		List<WebElement> tmzn = driver.findElements(By.xpath("//li[@role='option']"));
		for(int i=0;i<tmzn.size();i++) {
			String data2 = tmzn.get(i).getText();
			if(data2.equalsIgnoreCase("(UTC+07:00) Bangkok, Hanoi, Jakarta, Barnual, Gorno-Altaysk, Hovd, Krasnoyarsk, Novosibirsk, Tomsk")) {
				tmzn.get(i).click();
				break;
			}
		}
		driver.findElement(By.xpath("(//button[@type='button'])[11]")).click();
		}else {
			System.out.println("Time Zone not Enabled");
		}
		Thread.sleep(3000);
		
		//Consultation Base Fees
		driver.findElement(By.xpath("(//button[@type='button'])[12]")).click();
		WebElement fee = driver.findElement(By.xpath("//div[@class='MuiBox-root jss273']//input[@type='text']"));
		Thread.sleep(2000);
		if(fee.isEnabled()) {
			driver.findElement(By.xpath("(//button[@type='button'])[13]")).click();
		}else {
			System.out.println("Consultation fees not Enabled");
		}
		Thread.sleep(3000);
		
		//Doctor Profile URL
		WebElement url = driver.findElement(By.xpath("//div[@class='MuiBox-root jss278']//p"));
		Thread.sleep(2000);
		if(url.isDisplayed()) {
			String txt = driver.findElement(By.xpath("//div[@class='MuiBox-root jss278']//p")).getText();
			System.out.println(txt);
		}else {
			System.out.println("Doctor url not Displayed");
		}
		Thread.sleep(3000);
		
		//Signature
		WebElement sign = driver.findElement(By.xpath("//*[name()='svg' and @title='Upload Signature Image']"));
		Thread.sleep(2000);
		if(sign.isEnabled()) {
			driver.findElement(By.xpath("(//input[@id='files'])[2]")).sendKeys("D:\\Picture\\sign.jpg");
		}else {
			System.out.println("Signature not Enabled");
		}
		Thread.sleep(3000);
		
		//Doctor Profile QR Code
		WebElement qr = driver.findElement(By.xpath("//img[@class='jss253']"));
		Thread.sleep(2000);
		if(qr.isDisplayed()) {
			driver.findElement(By.xpath("(//button[@type='button'])[13]")).click();
		}else {
			System.out.println("Doctor qr not Enabled");
		}
		Thread.sleep(3000);
	}
}
