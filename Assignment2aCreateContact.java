package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2aCreateContact {

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
		
		//clicking on contacts
		driver.findElement(By.xpath("(//div[@class='x-panel-header'])[3]/a")).click();
		//clicking on create contact
		driver.findElement(By.xpath("//div[@class='frameSectionBody']//ul//li[2]")).click();
		
		//entering fields in create contact form
		driver.findElement(By.id("firstNameField")).sendKeys("Sankar");
		driver.findElement(By.id("lastNameField")).sendKeys("Subramanian");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("San");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("V S");
		
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("IT");
		driver.findElement(By.id("createContactForm_description")).sendKeys("Working in IT department");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("v.s.sankar.raj@gmail.com");
		
		//selecting state from drop down
		WebElement eleState = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select stateDD = new Select(eleState);
		stateDD.selectByVisibleText("New York");
		
		//click on create contact button
		driver.findElement(By.className("smallSubmit")).click();
		
		//click on Edit button
		driver.findElement(By.xpath("//a[@class='subMenuButtonDangerous']/preceding-sibling::a")).click();
		
		//clearing the description field
		driver.findElement(By.id("updateContactForm_description")).clear();
		
		//filling Important Note field
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Learning selenium");
		
		//click on update using xpath locator
		driver.findElement(By.xpath("(//input[@class='smallSubmit'])[1]")).click();
		
		//to get title of the resulting page
		System.out.println(driver.getTitle());
		
	}
	
}
