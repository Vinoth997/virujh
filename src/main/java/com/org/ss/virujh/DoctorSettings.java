package com.org.ss.virujh;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DoctorSettings {
	
	WebDriver driver;

	By loginbutn      = By.xpath("(//button[@type=\"button\"])[2]");
	By doctorbtn      = By.xpath("(//div[@class=\"MuiGrid-root MuiGrid-item\"])[1]");
	By emailid        = By.xpath("//input[@id=\"userName\"]");
	By password       = By.xpath("//input[@id=\"password\"]");
	By passeybtn      = By.xpath("//*[local-name()='svg']");
	By signinbtn      = By.xpath("//button[@type='submit']");
	By settings       = By.xpath("//button[@type='button']//span[contains(text(),'Settings')]");
	By docpersnl      = By.xpath("//a[@class='jss4030']//p[contains(text(),'Doctor')]");
	By canceltn       = By.xpath("//a[@href='/app/doctors/Doc_143/cancellation-reshedule']");
	By workschdl   	  = By.xpath("//a[@class='jss172']//p[contains(text(),'Work')]");
	By patcanclchkbox = By.xpath("(//input[@type='checkbox'])[1]");

	public DoctorSettings(WebDriver driver) {
		this.driver = driver;
	}

	public void login(String mail, String passwrd) throws InterruptedException {
		driver.findElement(loginbutn).click();
		driver.findElement(doctorbtn).click();
		driver.findElement(emailid).sendKeys(mail);
		driver.findElement(password).sendKeys(passwrd);
		driver.findElement(passeybtn).click();
		// Thread.sleep(4000);
		driver.findElement(signinbtn).click();
	}

	public void settingsmenu() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(settings).click();
		List<WebElement> li = driver.findElements(By.xpath("//a[@class='jss172']//p"));
		for (WebElement txt : li) {
			String text = txt.getText();
			System.out.println(text);
		}
	}

	public void cancellationopt() {
		driver.findElement(canceltn).click();
	}

	public void patirntcancellationopt() throws InterruptedException {

		WebElement chkbx = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));

		if (!chkbx.isSelected()) {
			chkbx.click();
			
			driver.findElement(By.xpath("(//span[@class='info-tip'])[2]")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("3");
			driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("3");
			driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("10");
			driver.findElement(By.xpath("(//span[@class='MuiIconButton-label'])[3]")).click();
		} else {
			driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).isEnabled();
			driver.findElement(By.xpath("(//span[@class='info-tip'])[2]")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("2");
			driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("2");
			driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("20");
			driver.findElement(By.xpath("(//span[@class='MuiIconButton-label'])[3]")).click();
		}
		WebElement alrt = driver.findElement(By.xpath("//div[@class='MuiAlert-message']"));
		if (alrt.isDisplayed()) {
			System.out.println(alrt.getText());
		}
	}

	public void patientreschedulechkbtn() throws InterruptedException {
		WebElement chkbx1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

		if (!chkbx1.isSelected()) {
			chkbx1.click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("(//span[@class='info-tip'])[2]")).click();

			driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("1");
			driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("2");
			driver.findElement(By.xpath("(//input[@type='text'])[6]")).sendKeys("3");
			driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
		} else {
			Thread.sleep(4000);
			driver.findElement(By.xpath("(//span[@class='info-tip'])[3]")).click();
			driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("4");
			driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("5");
			driver.findElement(By.xpath("(//input[@type='text'])[6]")).sendKeys("6");
			driver.findElement(By.xpath("(//span[@class='MuiIconButton-label'])[5]")).click();
		}
	}

	public void workschedules() throws InterruptedException {
		driver.findElement(workschdl).click();
		String txt = driver.findElement(By.xpath("//h6")).getText();
		System.out.println(txt);
	}

	public void consultationtime() {
		List<WebElement> time = driver.findElements(By.xpath("//div[@class='option-box session-option']"));
		for (int i = 0; i < time.size(); i++) {
			String data = time.get(i).getText();
			if (data.equalsIgnoreCase("15 minutes")) {
				time.get(i).click();
				break;
			}
		}
		try {
			driver.findElement(By.xpath("//p[contains(text(),'YES')]")).click();
		} catch (Exception e) {
		}
	}

	public void selectingday() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(By.xpath("(//td[@class='table-cell'])[1]")).click();
	}

	public void intimeselect() throws InterruptedException {

		driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();

		// driver.findElement(By.xpath("(//span[@class='MuiButton-label'])[4]")).click();
		// driver.findElement(By.xpath("(//input[@id='time-picker'])[1]")).clear();(//div[@class='slot-wrap'])[1]
		// driver.findElement(By.xpath("(//input[@id='time-picker'])[1]")).sendKeys("11:00
		// PM");//div[@class='MuiPickersClockPointer-pointer
		// MuiPickersClockPointer-animateTransform']
		List<WebElement> timeclck = driver.findElements(By.xpath("//div[@class='MuiPickersClock-clock']//following-sibling::span"));
		for (WebElement el : timeclck) {
			String txtt = el.getText();
			System.out.println(txtt);

		}

		driver.findElement(By.xpath("//div[@class=\"MuiPickersClock-squareMask\"]")).click();
		Thread.sleep(5000);

		// driver.findElement(By.xpath("//span[contains(text(),'7')]")).click();
		List<WebElement> hour = driver.findElements(By.xpath("//div[@class='MuiPickersClock-clock']//following-sibling::span"));
		for (int i = 0; i < hour.size(); i++) {
			String data1 = hour.get(i).getText();
			if (data1.equalsIgnoreCase("7")) {
				hour.get(i).click();
				break;
			}
		}

		try {
			driver.findElement(By.xpath("//div[@class=\"MuiPickersClock-squareMask\"]")).click();
			Thread.sleep(3000);
			List<WebElement> min = driver.findElements(By.xpath("//div[@class='MuiPickersClockPointer-pointer']//div"));
			for (int i = 0; i < min.size(); i++) {
				String data2 = min.get(i).getText();
				if (data2.equalsIgnoreCase("35")) {
					min.get(i).click();
					break;
				}
			}

			driver.findElement(By.xpath("//div[@class=\"MuiPickersClock-squareMask\"]")).click();
			Thread.sleep(3000);
			List<WebElement> ampm = driver.findElements(By.xpath("//span//h6"));
			for (int i = 0; i < ampm.size(); i++) {
				String data3 = ampm.get(i).getText();
				if (data3.equalsIgnoreCase("AM")) {
					ampm.get(i).click();
					break;
				}
			}
		}

		catch (ElementClickInterceptedException e) {
		}
		driver.findElement(By.xpath(
				"(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary'])[2]"))
				.click();
		// WebElement
		// okbtn=driver.findElement(By.xpath("(//button[@class='MuiButtonBase-root
		// MuiButton-root MuiButton-text MuiButton-textPrimary'])[2]"));
		// Actions ac=new Actions(driver);
		// ac.moveToElement(okbtn).click().perform();

		// okbtn.click();
	}

	public void leavetimeselect() throws InterruptedException {

		// driver.findElement(By.xpath("(//button[@type='button'])[4]"));
		driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();

		// driver.findElement(By.xpath("(//span[@class='MuiButton-label'])[4]")).click();
		// driver.findElement(By.xpath("(//input[@id='time-picker'])[1]")).clear();(//div[@class='slot-wrap'])[1]
		// driver.findElement(By.xpath("(//input[@id='time-picker'])[1]")).sendKeys("11:00
		// PM");//div[@class='MuiPickersClockPointer-pointer
		// MuiPickersClockPointer-animateTransform']
		List<WebElement> timeclck1 = driver
				.findElements(By.xpath("//div[@class='MuiPickersClock-clock']//following-sibling::span"));
		for (WebElement el1 : timeclck1) {
			String txtt1 = el1.getText();
			System.out.println(txtt1);

		}

		driver.findElement(By.xpath("//div[@class=\"MuiPickersClock-squareMask\"]")).click();
		Thread.sleep(5000);

		// driver.findElement(By.xpath("//span[contains(text(),'7')]")).click();
		List<WebElement> hour1 = driver
				.findElements(By.xpath("//div[@class='MuiPickersClock-clock']//following-sibling::span"));
		for (int i = 0; i < hour1.size(); i++) {
			String data4 = hour1.get(i).getText();
			if (data4.equalsIgnoreCase("10")) {
				hour1.get(i).click();
				break;
			}
		}

		try {
			driver.findElement(By.xpath("//div[@class=\"MuiPickersClock-squareMask\"]")).click();
			Thread.sleep(3000);
			List<WebElement> min1 = driver
					.findElements(By.xpath("//div[@class='MuiPickersClockPointer-pointer']//div"));
			for (int i = 0; i < min1.size(); i++) {
				String data5 = min1.get(i).getText();
				if (data5.equalsIgnoreCase("35")) {
					min1.get(i).click();
					break;
				}
			}

			driver.findElement(By.xpath("//div[@class=\"MuiPickersClock-squareMask\"]")).click();
			Thread.sleep(3000);
			List<WebElement> ampm1 = driver.findElements(By.xpath("//span//h6"));
			for (int i = 0; i < ampm1.size(); i++) {
				String data6 = ampm1.get(i).getText();
				if (data6.equalsIgnoreCase("PM")) {
					ampm1.get(i).click();
					break;
				}
			}
		}

		catch (ElementClickInterceptedException e) {
		}
		driver.findElement(By.xpath(
				"(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary'])[2]"))
				.click();
	}

}
