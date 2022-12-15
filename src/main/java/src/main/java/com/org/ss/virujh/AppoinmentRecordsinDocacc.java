package src.main.java.com.org.ss.virujh;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppoinmentRecordsinDocacc {
	
	WebDriver driver;
	
	By loginbutn      = By.xpath("//button[text()='Login']");
	By doctorbtn      = By.xpath("//span[text()='Doctor']");
	By emailid        = By.xpath("//input[@id=\"userName\"]");
	By password       = By.xpath("//input[@id=\"password\"]");
	By submitbtn      = By.xpath("//button[@type=\"submit\"]");
	By reportsbtn     = By.xpath("//a[@class='jss103 jss105']");
	By datepicker     = By.xpath("//div[@class='date-range-picker']");
	By fromdate       = By.xpath("//input[@placeholder='Early']");
	By frommnth       = By.xpath("//span[@class='rdrMonthPicker']//select");
	By fromyr         = By.xpath("//span[@class='rdrYearPicker']//select");
	By date			  = By.xpath("(//div[@class='rdrDays'])[2]//button");
	By todate         = By.xpath("//input[@placeholder='Continuous']");
	By tomonth		  = By.xpath("//span[@class='rdrMonthPicker']//select");
	By toyear		  = By.xpath("//span[@class='rdrYearPicker']//select");
	By tdate		  = By.xpath("(//div[@class='rdrDays'])[2]//button");
	By select         = By.xpath("//button[@type='button']//span[contains(text(),'Select')]");
	By searchtext     = By.xpath("//input[@name='searchText']");
	By exportbtn      = By.xpath("//div[@class='ExportButton']");
	By amountcolbtn   = By.xpath("//button[@type='button']//span[contains(text(),'Amount Collection')]");
	
	public AppoinmentRecordsinDocacc(WebDriver driver) {
		this.driver=driver;
	}
	
	public void login(String email,String passwrd) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement login = driver.findElement(loginbutn);
		js.executeScript("arguments[0].click()",login);
		driver.findElement(loginbutn).click();
		driver.findElement(doctorbtn).click();
		driver.findElement(emailid).sendKeys(email);
		driver.findElement(password).sendKeys(passwrd);
		driver.findElement(submitbtn).click();
		
	}
	
	public void reports() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(reportsbtn).click();
		driver.findElement(datepicker).click();
		driver.findElement(fromdate).click();
	}
	
	public void fromdate() {
		Select frommonth=new Select(driver.findElement(frommnth));
		frommonth.selectByVisibleText("September");
		Select fromyear=new Select(driver.findElement(fromyr));
		fromyear.selectByVisibleText("2021");
		List<WebElement> dat=driver.findElements(date);
		for(WebElement el:dat) {
			String text=el.getText();
			//System.out.println(text);
			if(text.equals("6")) {
			    el.click();
			}
			//if(el.getText().equalsIgnoreCase("6")) {
			//	el.click();
			//}
		}
	}
	
	public void todate() {
		driver.findElement(todate).click();
		Select tomnth=new Select(driver.findElement(tomonth));
		tomnth.selectByVisibleText("October");
		Select toyr=new Select(driver.findElement(toyear));
		toyr.selectByVisibleText("2021");
		List<WebElement> da=driver.findElements(tdate);
		for(WebElement el1:da) {
			String text1=el1.getText();
			if(text1.equals("7")) {
				el1.click();
			}
		}
	}
	
	public void selectbtn() {
		 
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(select)).click();
		
		/*try {
		WebElement selct=driver.findElement(select);
		selct.isDisplayed();
		WebElement selct1=driver.findElement(select);
		selct1.click();
		//Actions ac=new Actions(driver);
		//ac.moveToElement(driver.findElement(select)).click().perform();
		}
		catch(StaleElementReferenceException  e) {
		
		}*/
	}
	
	public void searchpatientreport() {
		driver.findElement(searchtext).sendKeys("arul");
	}

	public void patientappoinmentreports() {
		List<WebElement> li=driver.findElements(By.xpath("//tr"));
		for(WebElement list:li) {
			String text=list.getText();
			System.out.println(text);
		}
	}
	
	public void exportreports() {
		driver.findElement(exportbtn).click();
	}
	
	public void amountcollectionrep() throws InterruptedException {
		driver.findElement(amountcolbtn).click();
		driver.findElement(datepicker).click();
		Thread.sleep(3000);
		driver.findElement(select).click();
		List<WebElement> li1=driver.findElements(By.xpath("//table[@class='amount-table']//tr"));
		for(WebElement list1:li1) {
			String text1=list1.getText();
			System.out.println(text1);
		}
		driver.findElement(exportbtn).click();
	}

}
