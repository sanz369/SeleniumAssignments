package week2.day2;

import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class Assignment2cDuplicateLead {

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

			//click on email
			driver.findElement(By.xpath("//div[@class='x-tab-strip-wrap']/ul/li[3]/a[2]/em/span/span")).click();
			
			//to enter email
			driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("test@test.com");
			
			//to click on find leads button
			driver.findElement(By.xpath("(//button[@class='x-btn-text'])[6]")).click();
			
			//wait for results to laod
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(5000);
					
			//to click on the first resulting link
			driver.findElement(By.xpath("(//div[@class='x-grid3-body']/div/table/tbody/tr/td/div/a)[1]")).click();
			
			//to click to duplicate lead
			driver.findElement(By.linkText("Duplicate Lead")).click();
			
			String title=driver.getTitle();
			
			if(title.contains("Duplicate Lead")) {
				String name=driver.findElement(By.id("createLeadForm_firstName")).getAttribute("value");
				System.out.println(name);
				
				//to click on create lead
				driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
				
				//to get the first name of the duplicated lead
				String nameDup=driver.findElement(By.id("viewLead_firstName_sp")).getText();
				System.out.println(nameDup);
				
				if(name.equals(nameDup)) {
					System.out.println("Duplicate successful");
					driver.close();
				}
				else {
					System.out.println("Duplicate unsuccessful");
				}
			}
		}

	}

