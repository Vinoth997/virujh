package com.org.ss.virujh;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DocHospitalSettings {
	
	WebDriver driver;
	
	By hospimg     = By.xpath("//img[@alt='hospital logo']");
	By hospsetting = By.xpath("//p[contains(text(),'Hospital Settings')]");
	By upldimg     = By.xpath("//*[name()='svg' and @title='Upload Image']//following::input[@id='files']");
	By fields      = By.xpath("//p[contains(@class,'required-field')]");
	
	public DocHospitalSettings(WebDriver driver) {
		this.driver=driver;
	}
	
	public void login() throws InterruptedException {
		DoctorLogin dl = new DoctorLogin(driver);
		dl.login();
		dl.signIn();
	}
	
	public void hospitalSettings() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(hospimg).click();
		driver.findElement(hospsetting).click();
		List<WebElement> fields = driver.findElements(By.xpath("//p[contains(@class,'required-field')]"));
		for(WebElement field:fields) {
			String label=field.getText();
			System.out.println(label);
		}
		
		//Upload Image
		driver.findElement(upldimg).sendKeys("D:\\Picture\\img4.jpg");

		WebElement alert = driver.findElement(By.xpath("//div[@role='alert']"));

		if(alert.isDisplayed()) {
			String alrt = alert.getText();
			System.out.println("Alert msg "+"'"+alrt+"'"+" is displayed.");
		}else {
			System.out.println("No Alert msg displayed");
		}
		
		
		//Hospital Name
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		WebElement hname = driver.findElement(By.xpath("//input[@name='hospitalName']"));
		if(hname.isEnabled()) {
			hname.sendKeys(" And Clinic");
			driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
			WebElement alrt = driver.findElement(By.xpath("//div[@role='alert']"));
			String alrtmsg = alrt.getText();
			System.out.println(alrtmsg);
		}else {
			driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		}
		Thread.sleep(2000);
		String Title = driver.findElement(By.xpath("//div[@class='MuiBox-root jss99 jss69']//p")).getText();
		String newTitle = hname.getAttribute("value");
		assertEquals(newTitle,Title);
		
		//Landmark
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
		WebElement landmk = driver.findElement(By.xpath("//input[@name='landmark']"));
		if(landmk.isEnabled()) {
			landmk.sendKeys("Near VR Mall");
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
			WebElement alrt = driver.findElement(By.xpath("//div[@role='alert']"));
			String alrtmsg = alrt.getText();
			System.out.println(alrtmsg);
		}else {
			driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
		}
		
		//Country
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
		WebElement country = driver.findElement(By.xpath("//input[@name='country']"));
		if(country.isEnabled()) {
			country.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
		}else {
			driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
		}
		
		//Contact Number
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
		WebElement contnum = driver.findElement(By.xpath("//input[@name='phone']"));
		if(contnum.isEnabled()) {
			contnum.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
		}else {
			driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
		}
		
		//Address
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
		WebElement address = driver.findElement(By.xpath("//input[@name='street1']"));
		if(address.isEnabled()) {
			address.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
		}else {
			driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
		}
		
		//state/City
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
		WebElement state = driver.findElement(By.xpath("//input[@name='cityState']"));
		if(state.isEnabled()) {
			state.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[@type='button'])[8]")).click();
		}else {
			driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
		}
		
		//Pincode
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@type='button'])[8]")).click();
		WebElement pincode = driver.findElement(By.xpath("//input[@name='pincode']"));
		if(pincode.isEnabled()) {
			pincode.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[@type='button'])[9]")).click();
		}else {
			driver.findElement(By.xpath("(//button[@type='button'])[8]")).click();
		}
		
		//Email
		Thread.sleep(2000);
		WebElement email = driver.findElement(By.xpath("//input[@name='supportEmail']"));
		if(email.isEnabled()) {
			email.click();
		}else {
			System.out.println("Email is not enabled");
		}
	}
}
