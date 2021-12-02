package com.org.ss.virujh;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PatientLoginpage {

	WebDriver driver;

	By loginbutn     = By.xpath("//button[text()='Login']");
	By patientbutn   = By.xpath("//span[contains(text(),'Patient')]");
	By username      = By.xpath("//input[@id=\"userName\"]");
	By password      = By.xpath("//input[@id=\"password\"]");
	By signin        = By.xpath("//button[@type=\"submit\"]");
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

	public PatientLoginpage(WebDriver driver) {
		this.driver = driver;
	}

	public void loginButton() throws InterruptedException {
		Thread.sleep(3000);
		WebElement login = driver.findElement(loginbutn);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", login);
		
	}

	public void patientButton() throws InterruptedException {
		Thread.sleep(3000);
		WebElement patnt = driver.findElement(patientbutn);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", patnt);
	}

	public void userName(String UserName) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(username).sendKeys(UserName);
	}

	public void passwordd(String passwrd) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(password).sendKeys(passwrd);
	}

	public void signInbtn() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(signin).click();
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

	public void searchDoctor(String doctorname) {
		driver.findElement(searchbtn).click();
		driver.findElement(searchbtn).sendKeys(doctorname);
	}

	public void bookapoinment() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(bookapoinment).click();
	}

	public void selectingDate() throws InterruptedException {
		Thread.sleep(3000);
		while (true) {
			String month = driver.findElement(dateselect).getText();
			if (month.equalsIgnoreCase("November 2021")) {
				break;
			} else {
				driver.findElement(By.xpath(
						"//button[@class=\"MuiButtonBase-root MuiIconButton-root MuiPickersCalendarHeader-iconButton\"]"))
						.click();
			}
		}
		// driver.findElement(By.xpath("//div[@role=\"presentation\"]//button//span/p[contains(text(),'9')]")).click();
		Thread.sleep(3000);
		int date = 29;
		WebElement date1 = driver
				.findElement(By.xpath("//div[@role=\"presentation\"]//button//span/p[contains(text()," + date + ")]"));
		if (date1.getText().equalsIgnoreCase("9")) {
			date1.click();
		}
		WebElement time = driver
				.findElement(By.xpath("//button[contains(@class,'MuiButton-text')]//*[text()='9:30 PM']"));
		if (time.getText().equalsIgnoreCase("9:30 PM")) {
			time.click();
		}
	}

	public void confirmButton() {
		driver.findElement(confrmbtn).click();
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

	public void emptyfields() {
		System.out.println("\nError message if the fields are empty\n");
		driver.findElement(signin).click();
		List<WebElement> msg = driver.findElements(By.xpath("//h6"));
		for (WebElement txt : msg) {
			String err = txt.getText();
			System.out.println(err);
		}
	}
}
