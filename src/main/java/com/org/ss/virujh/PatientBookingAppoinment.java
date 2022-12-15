package com.org.ss.virujh;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PatientBookingAppoinment {

	WebDriver driver;

	By profilebutn   = By.xpath("//div[@class=\"MuiAvatar-root MuiAvatar-circle jss89 MuiAvatar-colorDefault\"]");
	By logoutbutn    = By.xpath("(//p[@class=\"MuiTypography-root jss91 MuiTypography-body1\"])[2]");
	By finddoctorbtn = By.xpath("//button[@type='button']");// (//span[@class=\"MuiButton-label\"])[1]
	By searchbtn     = By.xpath("//input[@name=\"search\"]");
	By bookapoinment = By.xpath("//span[contains(text(), 'Book Appointment')]");
	By dateselect    = By.xpath("//div[@class=\"MuiPickersSlideTransition-transitionContainer MuiPickersCalendarHeader-transitionContainer\"]//p");
	By confrmbtn     = By.xpath("//p[text()='CONFIRM']");
	By payment       = By.xpath("//button[@method=\"netbanking\"]");
	By hdfcbank      = By.xpath("//div[@id=\"bank-item-HDFC\"]");
	By paybutton     = By.xpath("//div[@id=\"footer\"]");

	public PatientBookingAppoinment(WebDriver driver) {
		this.driver = driver;
	}

	public void login() throws InterruptedException {
		PatientLogin pl = new PatientLogin(driver);
		pl.loginfn();
		
	}

	public void profileButton() {
		driver.findElement(profilebutn).click();
	}

	public void logoutButton() {
		driver.findElement(logoutbutn).click();
	}

	public void findDoctorbtn() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(finddoctorbtn).click();
	}

	public void searchDoctor(String doctorname) throws InterruptedException {
		driver.findElement(searchbtn).click();
		driver.findElement(searchbtn).sendKeys(doctorname);
		Thread.sleep(3000);
	}

	public void bookapoinment() throws InterruptedException {
		
		driver.findElement(bookapoinment).click();
	}

	public void selectingDate() throws InterruptedException {
		Thread.sleep(3000);
		while (true) {
			String month = driver.findElement(dateselect).getText();
			if (month.equalsIgnoreCase("December 2021")) {
				break;
			} else {
				driver.findElement(By.xpath(
						"//button[@class=\"MuiButtonBase-root MuiIconButton-root MuiPickersCalendarHeader-iconButton\"]"))
				.click();
			}
		}
		// driver.findElement(By.xpath("//div[@role=\"presentation\"]//button//span/p[contains(text(),'9')]")).click();
		Thread.sleep(3000);
//		int date = 9;
//		WebElement date1 = driver.findElement(By.xpath("//div[@role=\"presentation\"]//button//span//p[contains(text()," + date + ")]"));
//		WebDriverWait wait = new WebDriverWait(driver,10);
//		wait.until(ExpectedConditions.visibilityOf(date1)).getText();
//				//.findElement(By.xpath("//div[@role=\"presentation\"]//button//span/p[contains(text()," + date + ")]"));
//		if (date1.getText().equals("9")) {
//			date1.click();
//		}
		//div[@role=\"presentation\"]//button//span//p[contains(text(),'9')]
		List<WebElement> datee = driver.findElements(By.xpath("*//p[contains(text(),'16')]"));
		for(int i = 0;i<datee.size();i++) {
			String data=datee.get(i).getText();
			if(data.equals("16")) {
				datee.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		int timesel = driver.findElements(By.xpath("//p[contains(text(),'No slots')]")).size();
		System.out.println(timesel);
		if(timesel!=0) {
			String noslots = driver.findElement(By.xpath("//p[contains(text(),'No slots')]")).getText();
			System.out.println(noslots);
		}
		else {
			WebElement time = driver.findElement(By.xpath("//button[contains(@class,'MuiButton-text')]//*[text()='9:30 PM']"));
			if (time.getText().equalsIgnoreCase("9:30 PM")) {
				time.click();
			}
		}
	}

	public void confirmButton() {
		int txt = driver.findElements(By.xpath("//p[contains(text(),'select any')]")).size();
		System.out.println(txt);
		if(txt!=0) {
			String msg = driver.findElement(By.xpath("//p[contains(text(),'select any')]")).getText();
			System.out.println(msg);
		}
		else {
			driver.findElement(confrmbtn).click();
		}
	}

	public void paymentMethod() throws InterruptedException {
		driver.switchTo().frame(0);
		driver.findElement(payment).click();
		driver.findElement(hdfcbank).click();
		// driver.findElement(paybutton).click();
		Thread.sleep(4000);
		String parentHandle = driver.getWindowHandle(); // get the current window handle
		driver.findElement(paybutton).click(); // click some link that opens a new window

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's
													// your newly opened window)
		}
		driver.findElement(By.xpath("//button[@class=\"danger\"]")).click();
		// driver.close(); // close newly opened window when done with it
		driver.switchTo().window(parentHandle); // switch back to the original window
		// driver.findElement(By.xpath("//button[@id=\"fd-hide\"]")).click();

		Thread.sleep(4000);
		driver.switchTo().frame(0);
		WebElement retry = driver.findElement(By.xpath("//button[@id=\"fd-hide\"]"));
		Actions ac = new Actions(driver);
		ac.moveToElement(retry).click().perform();
		driver.findElement(By.xpath("//div[@id='modal-close']")).click();
		// driver.switchTo().frame(0);
		// WebElement close=driver.findElement(By.xpath("//div[@id='modal-close']"));
		// ac.moveToElement(close).click().perform();
		/*
		 * String parentHandle1 = driver.getWindowHandle(); // get the current window
		 * handle driver.findElement(By.xpath("//div[@id=\"root\"]"));// click some link
		 * that opens a new window
		 * driver.findElement(By.xpath("//button[@id=\"fd-hide\"]")).click(); for
		 * (String winHandle1 : driver.getWindowHandles()) {
		 * driver.switchTo().window(winHandle1); } driver.close();
		 * driver.switchTo().window(parentHandle1);
		 */
		// driver.findElement(By.xpath("(//form[@method=\"post\"]//button)[1]")).click();
	}

}
