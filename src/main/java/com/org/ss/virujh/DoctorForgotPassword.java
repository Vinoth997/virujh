package com.org.ss.virujh;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DoctorForgotPassword {
	
public WebDriver driver;
	
    By loginbutn   = By.xpath("(//button[@type=\"button\"])[2]");
	By doctorbtn   = By.xpath("(//div[@class=\"MuiGrid-root MuiGrid-item\"])[1]");
	By forgtpass   = By.xpath("//div[@class='MuiBox-root jss62 jss18']//h4");
	By phnum       = By.xpath("//input[@id='userName']");
	By rstpwdbtn   = By.xpath("//button[@type='submit']");
	
	public DoctorForgotPassword(WebDriver driver) {
		this.driver=driver;
	}
	
	public void doctorlogintab() {
		driver.findElement(loginbutn).click();
		driver.findElement(doctorbtn).click();
	}
	
	public void forgtpassfields() {
		driver.findElement(forgtpass).click();
		List<WebElement> fld=driver.findElements(By.tagName("p"));
		for(WebElement elt: fld) {
			String txt=elt.getText();
			System.out.println(txt);
		}
		
	}
	
	public void noemail() {
		driver.findElement(phnum).sendKeys("");
		driver.findElement(rstpwdbtn).click();
		List<WebElement> msg=driver.findElements(By.xpath("//h6[@class='MuiTypography-root jss77 MuiTypography-h6']"));
		for(WebElement elt1:msg) {
			String text=elt1.getText();
			System.out.println(text);
		}
	}
	
	public void invalidmail() {
		driver.findElement(phnum).sendKeys("addfdssd");
		driver.findElement(rstpwdbtn).click();
		//driver.switchTo().alert().getText();
	}
	
	public void unregisteredmail() {
		driver.findElement(phnum).sendKeys("abcdefgh@gmail.com");
		driver.findElement(rstpwdbtn).click();
		WebElement msg2=driver.findElement(By.xpath("//h6[@class='MuiTypography-root jss77 MuiTypography-h6']"));
		String text2=msg2.getText();
		if(!text2.isEmpty()) {
			System.out.println(text2);
		}else {
			System.out.println("No error message displayed");
		}
	}
	
	public void validmail() throws InterruptedException {
		//Thread.sleep(9000);
		WebElement toClear = driver.findElement(phnum);
    	toClear.sendKeys(Keys.CONTROL + "a");
    	toClear.sendKeys(Keys.DELETE);
		driver.findElement(phnum).sendKeys("abcdefgh@gmail.com");
		driver.findElement(rstpwdbtn).click();
		
	}

}
