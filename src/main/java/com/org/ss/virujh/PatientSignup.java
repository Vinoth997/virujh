package com.org.ss.virujh;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PatientSignup {
    
	WebDriver driver;
	
	By signup = By.xpath("//button[text()='Signup']");
	// Patient SignUp Page
	By patient  = By.xpath("//button[@class=\"MuiButtonBase-root MuiButton-root MuiButton-contained patientSgbtn\"]");
	By ppre     = By.xpath("//div[contains(text(),'Mr.')]");
	By pgen     = By.xpath("//div[@id='mui-component-select-gender']");
	By pfname   = By.xpath("//input[@name=\"firstName\"]");
	By plname   = By.xpath("//input[@name=\"lastName\"]");
	By pconnum  = By.xpath("//input[@name=\"phone\"]");
	By paltnum  = By.xpath("//input[@name=\"alternateContact\"]");
	By pmail    = By.xpath("//input[@name=\"email\"]");
	By pdob     = By.xpath("//button[@class=\"MuiButtonBase-root MuiIconButton-root\"]");
	By page     = By.xpath("//input[@name=\"age\"]");
	By padd     = By.xpath("//textarea[@name=\"address\"]");
	By pcity    = By.xpath("//input[@name=\"city\"]");
	By pstate   = By.xpath("//input[@name=\"state\"]");
	By pcoun    = By.xpath("//input[@name=\"country\"]");
	By ppinc    = By.xpath("//input[@name=\"pincode\"]");
	By ppass    = By.xpath("//input[@name=\"password\"]");
	By ppasschk = By.xpath("//button[@class=\'MuiButtonBase-root MuiIconButton-root pass-rvl-btn MuiIconButton-edgeEnd\']");
	By pcfmpass = By.xpath("//input[@name=\"confirmpassword\"]");
	By pcfpasck = By.xpath("(//button[@class=\'MuiButtonBase-root MuiIconButton-root pass-rvl-btn MuiIconButton-edgeEnd\'])[2]");
	By psubmit  = By.xpath("//button[@class=\"MuiButtonBase-root MuiButton-root MuiButton-text signup-btn\"]");
    


	public PatientSignup(WebDriver driver) {
		this.driver=driver;
		
	}

	public void signUpbtn() throws InterruptedException {
		WebElement sign = driver.findElement(signup);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", sign);
		Thread.sleep(3000);
	}

	// Patient Tab
	public void patientTab() throws InterruptedException {
		WebElement pat = driver.findElement(patient);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", pat);
		Thread.sleep(3000);
	}

	public void patientSignupTab() {
		driver.findElement(paltnum).sendKeys();
		driver.findElement(pmail).sendKeys();
		driver.findElement(pdob);
		driver.findElement(page);
	}

	public void patpre() throws InterruptedException {
		driver.findElement(ppre).click();
		List<WebElement> option = driver.findElements(By.xpath("//li[@role='option']"));
		Thread.sleep(3000);
		for (int i = 0; i < option.size(); i++) {
			String data = option.get(i).getText();
			if (data.equalsIgnoreCase("Mr.")) {
				option.get(i).click();
				break;
			}
		}
	}

	public void patGender() throws InterruptedException {
		driver.findElement(pgen).click();
		List<WebElement> option1 = driver.findElements(By.xpath("//li[@role='option']"));
		Thread.sleep(3000);
		for (int i = 0; i < option1.size(); i++) {
			String data = option1.get(i).getText();
			if (data.equalsIgnoreCase("Male")) {
				option1.get(i).click();
				break;
			}
		}
	}

	public void pFstLstname(String firstname, String lastname) {
		driver.findElement(pfname).sendKeys(firstname);
		driver.findElement(plname).sendKeys(lastname);
	}

	public void pContAltNumber(String contnum, String altcontnum) {

		driver.findElement(pconnum).sendKeys(contnum);
		driver.findElement(paltnum).sendKeys(altcontnum);
	}

	public void pateMail(String email) {
	
		driver.findElement(pmail).sendKeys(email);
	}

	public void pDateOfBrth() throws InterruptedException {
		driver.findElement(pdob).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//button[@class=\"MuiButtonBase-root MuiButton-root MuiButton-text MuiPickersToolbarButton-toolbarBtn\"]//span//h6"))
		.click();
		List<WebElement> option2 = driver
				.findElements(By.xpath("//div[@class=\"MuiPickersYearSelection-container\"]//div"));
		for (WebElement element2 : option2) {
			if (element2.getText().equals("1994")) {
				element2.click();
				break;
			}
		}
		while (true) {
			String mnth = driver.findElement(By.xpath(
					"//div[@class=\"MuiPickersSlideTransition-transitionContainer MuiPickersCalendarHeader-transitionContainer\"]//p"))
					.getText();
			if (mnth.equalsIgnoreCase("March 1994")) {

				break;
			} else {
				driver.findElement(By.xpath(
						"(//button[@class=\"MuiButtonBase-root MuiIconButton-root MuiPickersCalendarHeader-iconButton\"])[1]"))
				.click();
			}
		}
		
		List<WebElement> alldate = driver.findElements(By.xpath("//div[@class=\"MuiPickersCalendar-week\"]//div"));
		for (WebElement elt : alldate) {
			if (elt.getText().equals("7")) {
				elt.click();
				break;
			}
		}
	}

	public void patAge() {
		driver.findElement(page);
	}

	public void patAddress(String patAdd) {
		driver.findElement(padd).sendKeys(patAdd);
	}

	public void patCity(String patiCity) {
		driver.findElement(pcity).sendKeys(patiCity);
	}

	public void patState(String patntState) {
		driver.findElement(pstate).sendKeys(patntState);
	}

	public void patCountry(String patntCoun) {
		driver.findElement(pcoun).sendKeys(patntCoun);
	}

	public void patPincod(String patPincde) {
		driver.findElement(ppinc).sendKeys(patPincde);
	}

	public void patPasswrd(String patntPasswrd) {
		driver.findElement(ppass).sendKeys(patntPasswrd);
	}

	public void patPassShow() {
		driver.findElement(ppasschk).click();

	}

	public void patConfrmPass(String patConfrmpswrd) {
		driver.findElement(pcfmpass).sendKeys(patConfrmpswrd);
	}

	public void patConfrmPassShow() {
		driver.findElement(pcfpasck).click();

	}

	public void submit() throws InterruptedException {
		WebElement btn = driver.findElement(psubmit);
		if (btn.isEnabled()) {
			btn.click();
		} else {
			System.out.println("Not Visible");
		}
		WebElement msg=driver.findElement(By.xpath("//p[@class='MuiTypography-root jss11 MuiTypography-body1']"));
		String txt=msg.getText();
		System.out.println("\nAlert message if the email already registered\n");
		System.out.println(txt);
		System.out.println("\n\n");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text jss13']")).click();
	}
	
	public void emptyfields() {
		driver.findElement(psubmit).click();
		System.out.println("\nError message if the fields are empty\n");
		List<WebElement> error=driver.findElements(By.xpath("//label"));
		for(WebElement text:error) {
			String txt=text.getText();
			System.out.println(txt);
		}
	}
	
	public void invalid() throws InterruptedException {
		System.out.println("\nError message if the entries are invalid\n");
		driver.findElement(pfname).sendKeys("@$#$%415");
		driver.findElement(plname).sendKeys("131!@#");
		driver.findElement(pconnum).sendKeys("123123123423");
		driver.findElement(paltnum).sendKeys("@$#$%4");
		driver.findElement(pmail).sendKeys("adad1312");
		driver.findElement(pdob).sendKeys("27/32/1994");
		driver.findElement(page).sendKeys("-");
		driver.findElement(pcity).sendKeys("123423");
		driver.findElement(pstate).sendKeys("214231");
		driver.findElement(pcoun).sendKeys("12312");
		driver.findElement(ppass).sendKeys("12312");
		driver.findElement(ppass).clear();
		driver.findElement(ppass).sendKeys("asdfghjk");
		Thread.sleep(4000);
		List<WebElement> error=driver.findElements(By.xpath("//label"));
		for(WebElement text:error) {
			String txt=text.getText();
			System.out.println(txt);
		}
	}
	
	public void clearingfields() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(pfname).clear();
		driver.findElement(plname).clear();
		driver.findElement(pconnum).clear();
		driver.findElement(paltnum).clear();
		driver.findElement(padd).clear();
		driver.findElement(pcity).clear();
		driver.findElement(pstate).clear();
		driver.findElement(pcoun).clear();
		driver.findElement(ppinc).clear();
		driver.findElement(ppass).clear();
		driver.findElement(pcfmpass).clear();
	}

}
