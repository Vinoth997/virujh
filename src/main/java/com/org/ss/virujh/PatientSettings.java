package com.org.ss.virujh;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PatientSettings {
	
	WebDriver driver;
    
    By fields       = By.xpath("//div[@class='MuiBox-root jss1304 jss1291']//p");
    By loginbutn    = By.xpath("(//button[@type=\"button\"])[2]");
    By patientbutn  = By.xpath("(//button[@type=\"button\"])[3]");
    By username     = By.xpath("//input[@id=\"userName\"]");
    By password     = By.xpath("//input[@id=\"password\"]");
    By signin       = By.xpath("//button[@type=\"submit\"]");
	By settingsicon = By.xpath("//a[@class='jss116 jss118']//i");
    By uploadimage  = ById.xpath("//*[name()='svg' and @title='Upload Image']");
    By reports      = By.xpath("//a[@class='jss116 jss119']");
    By docsearch	= By.xpath("//input[@type='text']");
    By download     = By.xpath("(//button[@type='button'])[3]");
    By deletebtn	= By.xpath("(//button[@type='button'])[4]");
    
    public PatientSettings(WebDriver driver) {
  	  this.driver = driver;
    }
    
    public void patientLogin() throws InterruptedException {
    	Patientlogin pl = new Patientlogin(driver);
    	pl.loginfn();
    }

    public void Settingsbtn() throws InterruptedException {
  	  Thread.sleep(4000);
  	  driver.findElement(settingsicon).click();
    }
    
    public void Fields() throws InterruptedException {
    		List<WebElement> fields = driver.findElements(By.xpath("//p"));
             System.out.println(fields.size());

          for (WebElement element : fields) {
          	String name = element.getText();
          	System.out.println(name);

          }
         
         driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
         driver.findElement(By.xpath("//input[@name='firstName']")).isDisplayed();
         driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
         String ertx = driver.findElement(By.xpath("//div[@class='MuiAlert-message']")).getText();
         System.out.println(ertx);
         Thread.sleep(3000);
         
         driver.findElement(By.xpath("//button[@title='Close']")).click();
         Thread.sleep(5000);
         
         driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
         driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
         Thread.sleep(3000);
         
         driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
         WebElement landmark=driver.findElement(By.xpath("//input[@name='landmark']"));
         Actions ac=new Actions(driver);
         ac.moveToElement(landmark).doubleClick().sendKeys(Keys.CONTROL).sendKeys("A").sendKeys(Keys.BACK_SPACE).perform();
         landmark.sendKeys("Location");
         driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
         String ertm = driver.findElement(By.xpath("//div[@role='alert']")).getText();
         System.out.println(ertm);
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         
         driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
         boolean con=driver.findElement(By.xpath("//input[@name='country']")).isEnabled();
         System.out.println(con);
         driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
         Thread.sleep(4000);
         
         driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
         boolean lang = driver.findElement(By.xpath("//input[@name='primaryLanguages']")).isEnabled();
         System.out.println(lang);
         driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
         Thread.sleep(4000);
         
         driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
         boolean mail = driver.findElement(By.xpath("//input[@name='email']")).isEnabled();
         System.out.println(mail);
         driver.findElement(By.xpath("(//button[@type='button'])[8]")).click();
         Thread.sleep(4000);
         
         driver.findElement(By.xpath("(//button[@type='button'])[8]")).click();
         boolean add = driver.findElement(By.xpath("//input[@name='address']")).isEnabled();
         System.out.println(add);
         driver.findElement(By.xpath("(//button[@type='button'])[9]")).click();
         Thread.sleep(4000);
         
         driver.findElement(By.xpath("(//button[@type='button'])[9]")).click();
         boolean ste = driver.findElement(By.xpath("//input[@name='state']")).isEnabled();
         System.out.println(ste);
         driver.findElement(By.xpath("(//button[@type='button'])[10]")).click();
         Thread.sleep(4000);
         
         driver.findElement(By.xpath("(//button[@type='button'])[10]")).click();
         boolean city = driver.findElement(By.xpath("//input[@name='city']")).isEnabled();
         System.out.println(city);
         driver.findElement(By.xpath("(//button[@type='button'])[11]")).click();
         Thread.sleep(4000);
         
         driver.findElement(By.xpath("(//button[@type='button'])[11]")).click();
         boolean pincde = driver.findElement(By.xpath("//input[@name='pincode']")).isEnabled();
         System.out.println(pincde);
         driver.findElement(By.xpath("(//button[@type='button'])[12]")).click();
         Thread.sleep(4000);
         
         driver.findElement(By.xpath("(//button[@type='button'])[12]")).click();
         boolean seclang = driver.findElement(By.xpath("//input[@name='secondaryLanguages']")).isEnabled();
         System.out.println(seclang);
         driver.findElement(By.xpath("(//button[@type='button'])[13]")).click();
         Thread.sleep(4000);
         
         boolean phnnum = driver.findElement(By.xpath("//input[@name='phone']")).isEnabled();
         System.out.println(phnnum);
         
  }
    
    
    
    public void signinbtn() {
		 //driver.findElement(signin).click();
		
	}
	
	public void uploadImage() {
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("arguments[0]", driver.findElement(By.xpath("//*[name()='svg' and @title='Upload Image']")), "0");
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("D:\\Picture\\Image.jpg");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public void reportPage() throws InterruptedException { 
		Thread.sleep(4000);
		driver.findElement(reports).click();
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='MuiButton-label'][contains(text(),'save')]")).click();
		
		List<WebElement> er=driver.findElements(By.xpath("//div[@class='MuiDialogContent-root']//p"));
		for(WebElement elt:er) {
			String txt=elt.getText();
			System.out.println(txt);
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='MuiButton-label'][contains(text(),'OK')]")).click();
		Thread.sleep(3000);
		WebElement select=driver.findElement(By.xpath("//input[@id='files']"));
		select.sendKeys("D:\\Picture\\Image.jpg");
		WebElement textarea=driver.findElement(By.xpath("//textarea[@placeholder='Type here...']"));
		Actions ac1=new Actions(driver);
		ac1.moveToElement(textarea).click().sendKeys("Patient scan report").perform();
		driver.findElement(By.xpath("//button[@type='button']//span[contains(text(),'save')]")).click();
		String mss = driver.findElement(By.xpath("//div[@role='alert']")).getText();
		System.out.println(mss);
}
	
	public void searchdocument() throws InterruptedException {
		Thread.sleep(3000);
		WebElement search=driver.findElement(docsearch);
		Actions ac3=new Actions(driver);
		ac3.moveToElement(search).click().sendKeys("Report - Copy").perform();
		Thread.sleep(3000);
	}
	
	public void downloaddoc() {
		driver.findElement(download).click();
	}
	
	public void deletedoc() throws InterruptedException {
		WebElement search=driver.findElement(docsearch);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",search);
		Thread.sleep(2000);
		driver.findElement(docsearch).click();
	    WebElement clear=driver.findElement(docsearch);
	    clear.clear();
		Thread.sleep(3000);
		//WebElement search=driver.findElement(docsearch);
		Actions ac4=new Actions(driver);
		ac4.moveToElement(clear).click().doubleClick().sendKeys(Keys.BACK_SPACE).perform();	
      ac4.moveToElement(search).click().sendKeys("Image.jpg").perform();
		Thread.sleep(3000);
		List<WebElement> file=driver.findElements(By.xpath("//td"));//div[@role='alert']
		for(WebElement elt : file) {
			String files=elt.getText();
			System.out.println(files);
		}
		try{
			driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
			String msg = driver.findElement(By.xpath("//div[@role='alert']")).getText();
			System.out.println(msg);
		   }
		catch(NoSuchElementException e) {
			System.out.println("No Records found");
		}
	
	}

}
