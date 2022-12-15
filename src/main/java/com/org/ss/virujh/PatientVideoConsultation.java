package com.org.ss.virujh;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PatientVideoConsultation {
	
	public WebDriver driver;
	
	By patientapnmt = By.xpath("(//div[@style='border-left: 3px solid rgb(255, 75, 91);'])[1]");
	By startconslt  = By.xpath("//p[text()='START CONSULTATION']");
	By patvmic	    = By.xpath("//img[@src='/app/static/media/mic-on.f0dbb3ca.svg']");
	By vcwindowtext = By.xpath("//button[@type='button']//following::p");
	By details		= By.xpath("//button[@type='button']//following::h5");
	By information  = By.xpath("(//button[@type='button']//following::p)[4]");
	By joinbtn		= By.xpath("//span[text()='JOIN']/ancestor::button");
	By textmsg      = By.xpath("(//p)[4]");
	By chaticon		= By.xpath("//img[@src='/app/static/media/chatIcon.3ac88539.svg']");
	By textarea		= By.xpath("(//textarea[@class='message-box'])[1]");
	By sendermsg1	= By.xpath("//div[@class='chat-message is-sender']");
	By sendermsg2   = By.xpath("(//div[@class='chat-message is-sender'])[2]");
	By sendmsg		= By.xpath("//div[@class='send-btn']");
	By addfiles     = By.xpath("//input[@name='files']");
	By closebtn 	= By.xpath("//*[name()='svg' and @focusable='false']");
	By endcall      = By.xpath("//p[text()='End Call']//ancestor::button");
	By sendermsg3   = By.xpath("(//div[@class='chat-message is-sender'])[3]");
	By prespfile    = By.xpath("//div[@class='table-wrap']//a");
	
	
	public PatientVideoConsultation(WebDriver driver) {
		this.driver = driver;
	}



	public void patient_signin() throws InterruptedException {
		PatientLogin pl = new PatientLogin(driver);
		pl.loginfn();
		pl.signin();
	}
	
	public void patient_upcoming_appoinment() throws InterruptedException {
		//Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(driver,99);
		
		WebElement upcomingapt = driver.findElement(patientapnmt);
		wait.until(ExpectedConditions.elementToBeClickable(upcomingapt));
		
		if(upcomingapt.isEnabled()) {
			wait.until(ExpectedConditions.elementToBeClickable(upcomingapt));
			upcomingapt.click();
		}else {
			System.out.println("no appoinment found");
		}
		
		WebElement startcons = driver.findElement(startconslt);
		Thread.sleep(3000);
		startcons.click();
		
		WebElement mic = driver.findElement(patvmic);
		Thread.sleep(3000);
		mic.click();
		
		List<WebElement> vctext = driver.findElements(vcwindowtext);
		List<WebElement> det = driver.findElements(details);
		for(int i=0;i<vctext.size();i++) 
		{
			for(int j=i+1;j<det.size();j++) 
			{
				String text = vctext.get(i).getText();
				String text2 = det.get(i).getText();
				System.out.println(text + text2 );
			}
		}
		
		WebElement infomsg = driver.findElement(information);
		String infotxt = infomsg.getText();
		System.out.println(infotxt);
		
		//Thread.sleep(20000);
		WebElement joinbtnn = driver.findElement(joinbtn);
		//String btn = joinbtnn.getAttribute(infotxt);
		wait.until(ExpectedConditions.
				attributeContains(joinbtnn, "style", "background-color: rgb(0, 181, 255);"));
		if(joinbtnn.isEnabled()) {
				
			joinbtnn.click();
		}else {
			String txt1 = driver.findElement(textmsg).getText();
			System.out.println(txt1);
		}
//		String attr = joinbtnn.getAttribute("style");
//		String colr = "background-color: rgb(0, 181, 255);";
//		System.out.println(attr);
//		if(attr.equals(colr)) {
//			joinbtnn.click();
//		}else {
//			wait.until(ExpectedConditions.visibilityOf(joinbtnn));
//		}
		Thread.sleep(3000);
		WebElement chatbtn = driver.findElement(chaticon);
		chatbtn.click();
		
		Thread.sleep(3000);
		WebElement sendrmsg1 = driver.findElement(sendermsg1);
		WebElement txtarea = driver.findElement(textarea);
		Thread.sleep(1000);
		if(sendrmsg1.isDisplayed()) {
			txtarea.sendKeys("Im fine, Who are you ?");
			WebElement sndmsg = driver.findElement(sendmsg);
			wait.until(ExpectedConditions.elementToBeClickable(sndmsg));
			sndmsg.click();
		}
		
		Thread.sleep(2000);
		WebElement sendrmsg2 = driver.findElement(sendermsg2);
		if(sendrmsg2.isDisplayed()) {
			
			WebElement addfile = driver.findElement(addfiles);
			addfile.sendKeys("D:\\Picture\\img6.jpg");
			WebElement sndmsg = driver.findElement(sendmsg);
			sndmsg.click();
		}
		
		                  
		
		
		WebElement closebtnn = driver.findElement(closebtn);
		if(closebtnn.isEnabled()) {
			
			//closebtnn.click();
		}else {
			System.out.println("Close button is not functioned");
		}
		
		
		
		
	}
	
	public void prescription_validation() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
			WebElement msg3 = driver.findElement(sendermsg3);
			if(msg3.isDisplayed()) {
				System.out.println("prescription ");
				List<WebElement> prescriptionreport = driver.findElements(prespfile);
				for(int i=0;i<prescriptionreport.size();i++) {
					String prescp = prescriptionreport.get(i).getText();
					System.out.println(prescp);
					if(prescp.concat(".pdf") != null) {
					prescriptionreport.get(i).click();
					}
				}
			}
		
	}
}
