package com.org.ss.virujh;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DoctorSignup {

	WebDriver driver;
	
	By signupbutn   = By.xpath("//button[contains(text(),'Signup')]");
	By doctorbtn    = By.xpath("//button//span//b[contains(text(),'Doctor')]");
	By dfirstname   = By.xpath("//input[@name='firstName']");
	By dlastname    = By.xpath("//input[@name='lastName']");
	By dhospname    = By.xpath("//input[@name='hospitalName']");
	By dspec        = By.xpath("//input[@name='speciality']");
	By dqualifi	    = By.xpath("//input[@name='qualification']");
	By dprmocde     = By.xpath("//input[@name='promotionalCode']");
	By dregnum      = By.xpath("//input[@name='registrationNumber']");
	By dexperi	    = By.xpath("//input[@name='experience']");
	By dcontnum		= By.xpath("//input[@name='number']");
	By demail		= By.xpath("//input[@name='email']");
	By dupdocumt    = By.xpath("//input[@name='registrationIdProofFile']");
	By dpasswrd     = By.xpath("//input[@name='password']");
	By dpasseyebtn  = By.xpath("(//button[@type='button'])[3]");
	By dcnfrmpass   = By.xpath("//input[@name='ConfirmPassword']");
	By dcfpaseyebtn = By.xpath("(//button[@type='button'])[4]");
	By submit       = By.xpath("//button//span[contains(text(),'Submit')]");
	
	public DoctorSignup(WebDriver driver) {
		this.driver=driver;
	}
	
	public void loginasdoctor() {
		driver.findElement(signupbutn).click();
		driver.findElement(doctorbtn).click();
	}
	
	public void validentry(String fname,String lname,String hname,String specli,String qualif,String promocode,String regnum,String expernce,
			               String contctnum,String email,String passwrd,String confrmpasswrd) throws InterruptedException 
	{
		driver.findElement(dfirstname).sendKeys(fname);
		driver.findElement(dlastname).sendKeys(lname);
		driver.findElement(dhospname).sendKeys(hname);
		driver.findElement(dspec).sendKeys(specli);
		driver.findElement(dqualifi).sendKeys(qualif);
		driver.findElement(dprmocde).sendKeys(promocode);
		driver.findElement(dregnum).sendKeys(regnum);
		driver.findElement(dexperi).sendKeys(expernce);
		driver.findElement(dcontnum).sendKeys(contctnum);
		driver.findElement(demail).sendKeys(email);
		driver.findElement(dupdocumt).sendKeys("E:\\Report.pdf");
		WebElement pass=driver.findElement(dpasswrd);
		pass.sendKeys(passwrd);
		WebElement eybtn1=driver.findElement(dpasseyebtn);
		eybtn1.click();
		if(pass.isDisplayed()) {
			System.out.println("Able to see the password");
		}else {
			System.out.println("eye button is not working");
		      }
		WebElement cnfpass=driver.findElement(dcnfrmpass);
		cnfpass.sendKeys(confrmpasswrd);
		WebElement eybtn2=driver.findElement(dcfpaseyebtn);
		eybtn2.click();
		if(cnfpass.isDisplayed()) {
			System.out.println("Able to see the password");
		}else {
			System.out.println("eye button is not working");
			}
		Thread.sleep(3000);
		driver.findElement(submit).click();
		String msg=driver.findElement(By.xpath("(//div[@class='MuiDialogContent-root']//p)[2]")).getText();
		System.out.println(msg);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button//span[contains(text(),'OK')]")).click();
	}
	
	public void emptyfields() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(submit).click();
		WebElement err=driver.findElement(By.xpath("//label"));
		if(err.isDisplayed()) {
			System.out.println("Error msg is visible");
			List<WebElement> li=driver.findElements(By.xpath("//label"));
			for(WebElement txt:li) {
				String text=txt.getText();
				System.out.println(text);
			}
		}else {
			System.out.println("No error msg is displayed");
		}
	}
	
	public void invalidentry() throws InterruptedException {
		driver.findElement(dfirstname).sendKeys("fdfgd122@");
		driver.findElement(dlastname).sendKeys("kllkj1&#");
		driver.findElement(dhospname).sendKeys("fdfgd122@#");
		driver.findElement(dspec).sendKeys("**(#4-4--3");
		driver.findElement(dqualifi).sendKeys("786");
		driver.findElement(dprmocde).sendKeys("+++");
		driver.findElement(dregnum).sendKeys("+++");
		driver.findElement(dexperi).sendKeys("23424");
		driver.findElement(dcontnum).sendKeys("23143242435");
		driver.findElement(demail).sendKeys("efdsfdg");
		driver.findElement(dpasswrd).sendKeys("efdsfdg");
		driver.findElement(dcnfrmpass).sendKeys("fdfgd122@#");
		Thread.sleep(4000);
		driver.findElement(submit).click();
		WebElement err=driver.findElement(By.xpath("//label"));
		if(err.isDisplayed()) {
			System.out.println("Error msg is visible");
			List<WebElement> li=driver.findElements(By.xpath("//label"));
			for(WebElement txt:li) {
				String text=txt.getText();
				System.out.println(text);
			}
		}else {
			System.out.println("No error msg is displayed");
		}
	}
	
	public void clearfields() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(dfirstname).clear();
		driver.findElement(dlastname).clear();
		driver.findElement(dhospname).clear();
		driver.findElement(dspec).clear();
		driver.findElement(dqualifi).clear();
		driver.findElement(dprmocde).clear();
		driver.findElement(dregnum).clear();
		driver.findElement(dexperi).clear();
		driver.findElement(dcontnum).clear();
		driver.findElement(demail).clear();
		driver.findElement(dpasswrd).clear();
		driver.findElement(dcnfrmpass).clear();
	}

}
