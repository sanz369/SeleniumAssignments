package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2bEditLead {

	public static void main(String[] args) {
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
		
		//to enter first name
		driver.findElement(By.xpath("(//div[@class='x-form-element'])[14]/input")).sendKeys("Test");
		
		//to click find leads
		driver.findElement(By.xpath("(//button[@class='x-btn-text'])[6]")).click();
		
		//wait for results to laod
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//to click on the first resulting link
		driver.findElement(By.xpath("(//div[@class='x-grid3-body']/div/table/tbody/tr/td/div/a)[1]")).click();
		
		//title of the page
		System.out.println(driver.getTitle());
		
		//to click edit
		driver.findElement(By.xpath("(//a[@class='subMenuButton'])[3]")).click();

		//to change company name
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("TestCompany");
		
		//to click on update
		driver.findElement(By.xpath("(//input[@class='smallSubmit'])[1]")).click();
		
		//to close the browser
		driver.close();
	}


}
