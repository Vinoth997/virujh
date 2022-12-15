package com.org.ss.virujh;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DoctorVideoConsultation {
	
	public WebDriver driver;
	
	
	By videoconslt    = By.xpath("//span[text()='VIDEO CONSULTATION']");
	By micbtn         = By.xpath("//img[@src='/app/static/media/mic-on.f0dbb3ca.svg']");
	By joinbtn		  = By.xpath("//span[text()='JOIN']/ancestor::button");
	By textmsg      = By.xpath("//p");
	By stopvideo      = By.xpath("//img[@src='/app/static/media/video-off.6e52f859.svg']");
	By alert1		  = By.xpath("(//div[contains(@class,'MuiDialogContent-root')]//p)[1]");
	By dismissbtn	  = By.xpath("//span//p[text()='DISMISS']");
	By patientlist    = By.xpath("//img[@src='/app/static/media/patientlist.66873478.svg']");
	By sidescreen     = By.xpath("//div[@class='sidebar-screens']//p");
	By sidescrnmpty   = By.xpath("//div[@class='sidebar-screens']//div[text()]");
	By endcall        = By.xpath("//p[text()='End Call']//ancestor::button");
	By cancelpatnt    = By.xpath("//div[@title='Cancel Patient']");
	By addfiles       = By.xpath("//input[@id='file-input']");
	By sendmsg        = By.xpath("//div[@class='send-btn']");
	By strtconstbtn   = By.xpath("(//div[@title='Start Consultation'])[1]");
	By openchat       = By.xpath("//button[@title='Open Chat']");
	By chaticon       = By.xpath("(//textarea[@class='message-box'])[1]");
	By chatmsg        = By.xpath("//div[@class='chat-message is-user']");
	By prescription   = By.xpath("//div[@title='Open Prescription']");
	By observation    = By.xpath("//input[@placeholder='Fever']");
	By diagnosis      = By.xpath("//input[@placeholder='Dengue Fever']");
	By type 		  = By.xpath("//input[@placeholder='Tab']");
	By medicine       = By.xpath("//input[@name='Medicine']");
	By dose			  = By.xpath("//input[@name='Dose']");
	By whentotake     = By.xpath("//input[@name='whenToTake']");
	By frequency      = By.xpath("//input[@name='Freq.']");
	By duration       = By.xpath("//input[@name='Duration']");
	By instruction    = By.xpath("//input[@name='Instructions']");
	By advice         = By.xpath("//input[@placeholder='Drink Water']");
	By testrequest    = By.xpath("//input[@placeholder='CBC, Sugar Fasting']");
	By nextsession    = By.xpath("//input[@type='checkbox']");
	By addmore		  = By.xpath("(//*[name()='svg'])[6]");
	By savebtn        = By.xpath("//button[@type='submit']");
	By deletemedic    = By.xpath("//button//img[@src='/app/static/media/trashred.8c38e7c7.svg']");
	By sno			  = By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/div[2]/div/div[2]/div[7]/div//p");
	By nextsndatsel   = By.xpath("//button//img[@src='/app/static/media/newCalender.c15bce5d.svg']"); 
	By yearbtn		  = By.xpath("(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiPickersToolbarButton-toolbarBtn'])[1]");
	By yearlist       = By.xpath("//div[@class='MuiPickersYearSelection-container']//div");
	By month		  = By.xpath("//div[@class='MuiPickersCalendarHeader-switchHeader']//div[@class='MuiPickersSlideTransition-transitionContainer MuiPickersCalendarHeader-transitionContainer']");
	By nextbtn        = By.xpath("(//div[@class='MuiPickersBasePicker-pickerView']//button[contains(@class,'MuiPickersCalendarHeader-iconButton')])[2]");
	By previousbtn    = By.xpath("(//button[@class='MuiButtonBase-root MuiIconButton-root MuiPickersCalendarHeader-iconButton'])[1]");
	By date			  = By.xpath("//div[@class='MuiPickersCalendar-week']//div//p");
	By okbtn          = By.xpath("//span[text()='OK']");
	By cancelbtn      = By.xpath("//span[text()='Cancel']");
	By sessionslot    = By.xpath("(//div[@class='MuiInputAdornment-root MuiInputAdornment-positionEnd'])[2]//button");
	By sessiontime    = By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text']//p");
	By sessioncnfrm   = By.xpath("//button//p[text()=' Confirm ']");
	By backbutton     = By.xpath("//button[@title='Back to patient list']");
	By editprescrpt   = By.xpath("//span[text()='Edit Prescription']");
	By prescpsave     = By.xpath("//span[text()='Save']");
	By cmptsendprpt   = By.xpath("//span[text()='Complete & Send Prescription']/ancestor::button");
	By alreadybkdalrt = By.xpath("//div[@class='MuiDialogContent-root']//p[contains(text(),'date')]");
	By yesbtn         = By.xpath("//p[text()='YES']");
	By nobtn          = By.xpath("//p[text()='NO']");
	By successalrt    = By.xpath("//div[@role='alert']");
	By messagebtn     = By.xpath("//div[@title='Open Chat']");
	By prescrpdwnld   = By.xpath("//div[@class='table-wrap']//a");
	By leavecosult    = By.xpath("/html/body/div[3]/div[3]/div/div/div/div//p");
	By compendsession = By.xpath("//p[contains(text(),'End Session')]/parent::div");
	By needjoinagain  = By.xpath("//p[contains(text(),'some issues')]/parent::div");
	
	public DoctorVideoConsultation(WebDriver driver) {
		this.driver = driver;
	}
	
	public void doctor_signin() throws InterruptedException {
		DoctorLogin dl = new DoctorLogin(driver);
		dl.login();
		dl.signIn();
	}
	
	public void doc_video_consultation() throws InterruptedException {
		Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(driver, 99);
		WebElement videocnslt = driver.findElement(videoconslt);
		videocnslt.click();
		Thread.sleep(2000);
		WebElement micbtnn = driver.findElement(micbtn);
		micbtnn.click();
		Thread.sleep(15000);
		WebElement joinbtnn = driver.findElement(joinbtn);
		wait.until(ExpectedConditions.
		attributeContains(joinbtnn, "style", "background-color: rgb(0, 181, 255);"));
		String attr = joinbtnn.getAttribute("style");
		String colr = "background-color: rgb(0, 181, 255);";
		System.out.println(attr);
		if(attr.equals(colr)) {
			joinbtnn.click();
		}else {
			String txt1 = driver.findElement(textmsg).getText();
			System.out.println(txt1);
			//wait.until(ExpectedConditions.visibilityOf(joinbtnn));
		}
		//joinbtnn.click();
		Thread.sleep(2000);
		WebElement stopvideobtn = driver.findElement(stopvideo);
		stopvideobtn.click();
		Thread.sleep(2000);
		WebElement alertel = driver.findElement(alert1);
		if(alertel.isDisplayed()) {
			String text = alertel.getText();
			System.out.println(text);
			driver.findElement(dismissbtn).click();
		}
		Thread.sleep(2000);
		WebElement patlist = driver.findElement(patientlist);
		patlist.click();
		Thread.sleep(2000);
		WebElement sidescrntitle = driver.findElement(sidescreen);
		String sidescreentitletxt = sidescrntitle.getText();
		String expectedtitle ="Patient List";
		Assert.assertEquals(sidescreentitletxt, expectedtitle);

		WebElement sidescreennopatnt = driver.findElement(sidescrnmpty);		
		if(sidescreennopatnt.isDisplayed()) {
			String emptylisttext = sidescreennopatnt.getText();
			System.out.println(emptylisttext);
		}

		//driver.findElement(By.xpath("//button[@type='button']//span[text()='JOIN']")).click();
		Thread.sleep(6000);

		List<WebElement> patientlist = driver.findElements(By.xpath("//body/div[@id='root']/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div"));
		for(int i=0;i<patientlist.size();i++) {
			String patientlists = patientlist.get(i).getText();
			System.out.println(patientlists);
		}

		WebElement startconsltbtn = driver.findElement(strtconstbtn);
		if(startconsltbtn.isEnabled()) {
			startconsltbtn.click();
		}else {
			System.out.println("Start consultation button not enabled");
		}

		Thread.sleep(3000);
		WebElement openchatbtn = driver.findElement(openchat);
		openchatbtn.click();

		Thread.sleep(3000);
		WebElement chatmesg = driver.findElement(chaticon);
		chatmesg.sendKeys("Hai, how are you.");

		Thread.sleep(3000);
		WebElement sndbtn = driver.findElement(sendmsg);
		wait.until(ExpectedConditions.visibilityOf(sndbtn));
		sndbtn.click();

		Thread.sleep(3000);
		WebElement addfile = driver.findElement(addfiles);
		addfile.sendKeys("D:\\Report.pdf");
		Thread.sleep(2000);
		sndbtn.click();

		List<WebElement> chtmsg = driver.findElements(chatmsg);
		for(int i=0;i<chtmsg.size();i++) {
			String messg = chtmsg.get(i).getText();
			System.out.println(messg);
		}
		//WebElement backbtn = driver.findElement(backbutton);	
	}
	
	public void prescription_window() throws InterruptedException {

		Thread.sleep(2000);
		WebElement prescrp = driver.findElement(prescription);
		prescrp.click();
		Thread.sleep(2000);
		WebElement observ = driver.findElement(observation);
		observ.sendKeys("Fever");
		Thread.sleep(2000);
		WebElement diagnos = driver.findElement(diagnosis);
		diagnos.sendKeys("Viral Fever");
		Thread.sleep(2000);
		WebElement typeof = driver.findElement(type);
		typeof.sendKeys("Tablet");
		Thread.sleep(2000);
		WebElement medname = driver.findElement(medicine);
		medname.sendKeys("DoLo 650");
		Thread.sleep(2000);
		WebElement dosage = driver.findElement(dose);
		dosage.sendKeys("1");
		Thread.sleep(2000);
		WebElement whentotke = driver.findElement(whentotake);
		whentotke.sendKeys("After Breakfast,Lunch and Dinner");
		Thread.sleep(2000);
		WebElement freq = driver.findElement(frequency);
		freq.sendKeys("Daily");
		Thread.sleep(2000);
		WebElement days = driver.findElement(duration);
		days.sendKeys("5");
		Thread.sleep(2000);
		WebElement instruct = driver.findElement(instruction);
		instruct.sendKeys("Take some rest");
		Thread.sleep(2000);
		WebElement advicee = driver.findElement(advice);
		advicee.sendKeys("Drink boiled water");
		Thread.sleep(2000);
		WebElement test = driver.findElement(testrequest);
		test.sendKeys("Sugar Fasting");
		Thread.sleep(2000);
		WebElement addmoreopt = driver.findElement(addmore);
		addmoreopt.click();

		List<WebElement> textfield = driver.findElements(type);
		for(int i=0;i<textfield.size();i++) {
			String attr = textfield.get(i).getAttribute("value");
			if(attr.isEmpty()) {
				textfield.get(i).sendKeys("Tablet");
			}
		}
		List<WebElement> medc = driver.findElements(medicine);
		for(int i=0;i<medc.size();i++) {
			String medic = medc.get(i).getAttribute("value");
			if(medic.isEmpty()) {
				medc.get(i).sendKeys("Vicks Action 500");
			}
		}

		Thread.sleep(3000);
		String beforexpath = "(//button//img[@src='/app/static/media/trashred.8c38e7c7.svg'])[";
		String afterxpath = "]";

		List<WebElement> dltbtn = driver.findElements(sno);
		for(int i=0;i<dltbtn.size();i++) {
			String actualxpath = beforexpath+i+afterxpath;
			System.out.println(actualxpath);
			String txt = dltbtn.get(i).getText();
			System.out.println(txt);
			if(txt.contains("2"))   {
				i=i+1;
				actualxpath = beforexpath+i+afterxpath;
				System.out.println(actualxpath);
				driver.findElement(By.xpath(actualxpath)).click();
			}
		}

	}
	
	public void next_session() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 99);
		Thread.sleep(2000);
		WebElement chkbx = driver.findElement(nextsession);
		chkbx.click();
		Thread.sleep(2000);
		WebElement sessiondate = driver.findElement(nextsndatsel);
		sessiondate.click();
		Thread.sleep(2000);
		WebElement yrbtn = driver.findElement(yearbtn);
		yrbtn.click();
		Thread.sleep(2000);
		List<WebElement> yearlistt = driver.findElements(yearlist);
		for(WebElement elmt : yearlistt) {
			if(elmt.getText().equals("2022")) {
				elmt.click();
				break;
			}
		}

		Thread.sleep(4000);
		try {

			List<WebElement> montth = driver.findElements(month);
			for(int i=0;i<montth.size();i++) {
				String monthtext=montth.get(i).getText();
				if(monthtext.equalsIgnoreCase("January 2022")) {
					break;
				}else {
					WebElement nextbtnn = driver.findElement(nextbtn);
					nextbtnn.click();
				}
			}
		}
		catch(StaleElementReferenceException e) {
		}

		Thread.sleep(2000);
		List<WebElement> datel = driver.findElements(date);
		for(int i=0;i<datel.size();i++) {
			String datetext = datel.get(i).getText();
			if(datetext.equals("30")) {
				datel.get(i).click();
			}
		}
		Thread.sleep(3000);
		WebElement okbutn = driver.findElement(okbtn);
		okbutn.click();

		WebElement session = driver.findElement(sessionslot);
		session.click();

		List<WebElement> sessiontm = driver.findElements(sessiontime);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(sessiontime));
		for(WebElement tme : sessiontm) {
			if(tme.getText().equals("9:00 AM")) {
				tme.click();
			}
		}
		Thread.sleep(2000);
		WebElement sessionconfm = driver.findElement(sessioncnfrm);
		sessionconfm.click();

		WebElement sidescroll = driver.findElement(By.xpath("//div[@class='sidebar-content is-open']"));
		sidescroll.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,100)"); 

		WebElement savebutton = driver.findElement(savebtn);
		savebutton.click();

		try {
			WebElement editprescription = driver.findElement(editprescrpt);
			editprescription.click();
		}catch(StaleElementReferenceException e) {

		}
		Thread.sleep(2000);		
		try {
			WebElement prescripsavebtn = driver.findElement(prescpsave);
			prescripsavebtn.click();
		}catch(StaleElementReferenceException e) {

		}

		Thread.sleep(2000);
		WebElement completeandsend = driver.findElement(cmptsendprpt);
		completeandsend.click();	
	}
	
	
	public void prescription_validation() throws InterruptedException {
//		WebElement backbuttn = driver.findElement(backbutton);
//		backbuttn.click();
		
		
		try {
			List<WebElement> alert = driver.findElements(alreadybkdalrt);
			for(int i=0;i<alert.size();i++) {
				String alertxt = alert.get(i).getText();
				System.out.println(alertxt);
			}
			Thread.sleep(2000);
			WebElement yesbuttn = driver.findElement(yesbtn);
			yesbuttn.click();
			WebElement successalert = driver.findElement(successalrt);
			String alert2 = successalert.getText();
			System.out.println(alert2);
		}catch(NoSuchElementException e) {

		}
		Thread.sleep(2000);
		JavascriptExecutor js =(JavascriptExecutor)driver;
		WebElement msgbutton = driver.findElement(messagebtn);
		js.executeScript("arguments[0].scrollIntoView(true)",msgbutton);
		Thread.sleep(2000);
		msgbutton.click();
		Thread.sleep(2000);
		WebElement mscchat = driver.findElement(By.xpath("(//div[@class='chat-message is-user'])[3]"));
		js.executeScript("arguments[0].scrollIntoView(true)", mscchat);

		List<WebElement> prescriptiond = driver.findElements(prescrpdwnld);
		for(int i=0;i<prescriptiond.size();i++) {
			String textdown = prescriptiond.get(i).getText();
			if(!textdown.isEmpty()) {
				System.out.println("Prescription reports are visible ");
			}else {
				System.out.println("Prescription not visible");
			}

			System.out.println(textdown);

		}
	}
	
	public void end_call() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		WebElement endcallbtn = driver.findElement(endcall);
		endcallbtn.click();
		List<WebElement> leaveconsultation = driver.findElements(leavecosult);
		for(WebElement txt : leaveconsultation) {
			String text = txt.getText();
			System.out.println(text);
		}
		WebElement needtojoin = driver.findElement(needjoinagain);
		boolean enabled = needtojoin.isEnabled();
		System.out.println(enabled);
		WebElement completesession = driver.findElement(cmptsendprpt);
		if(completesession.isEnabled()) {
			completesession.click();
		}
		
	}
	
}
