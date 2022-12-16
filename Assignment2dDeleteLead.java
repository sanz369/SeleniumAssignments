package week2.day2;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import io.cucumber.testng.AbstractTestNGCucumberTests;


public class Assignment2dDeleteLead {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps");
		
		//logging in
		driver.findElement(By.id("username")).sendKeys("democsr");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//clicking on CRM/SFA hyperlink
		driver.findElement(By.partialLinkText("CRM")).click();
		
		//click on leads
		driver.findElement(By.linkText("Leads")).click();
		
		//click on find leads
		driver.findElement(By.xpath("//div[@id='left-content-column']/div/div[2]/ul/li[3]")).click();
		
		//click on phone number
		driver.findElement(By.xpath("//div[@class='x-tab-strip-wrap']/ul/li[2]/a[2]/em/span/span")).click();
		
		//to enter phone number
		driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).clear();
		driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).sendKeys("91");
		driver.findElement(By.xpath("//input[@name='phoneAreaCode']")).sendKeys("892");
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("1757847");
		
		//to click on find leads button
		driver.findElement(By.xpath("(//button[@class='x-btn-text'])[6]")).click();
				
		//wait for results to laod
		Thread.sleep(5000);
		
		//to click on the first resulting link
		driver.findElement(By.xpath("(//div[@class='x-grid3-body']/div/table/tbody/tr/td/div/a)[1]")).click();
		
		//to capture leadID
		String wholeID=driver.findElement(By.id("viewLead_companyName_sp")).getText();
		String number=wholeID.replaceAll("[^0-9]", "");
		System.out.println(number);
		
		//to click on delete
		driver.findElement(By.linkText("Delete")).click();
		
		//to click find leads
		driver.findElement(By.xpath("//div[@id='left-content-column']/div/div[2]/ul/li[3]")).click();
		
		//to enter the captured lead ID
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(number);
		
		//to click on find leads
		driver.findElement(By.xpath("(//button[@class='x-btn-text'])[6]")).click();
		
		
		
		Thread.sleep(5000);
		//to get the number of records
		WebElement eleRecords = driver.findElement(By.className("x-paging-info"));
		String acText = ((WebElement) eleRecords).getText();
		System.out.println(acText);
		//String expectedText="No records to display";
		
		
		if(acText.contains("No rec")) {
			
			System.out.println("Deletion successful");
			driver.close();
		}
		else {
			System.out.println("Deletion unsuccessful");
		}

	
	}

}
