package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchApplicationAssignment {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(" https://login.salesforce.com/");
		
		WebElement eleUsername = driver.findElement(By.id("username"));
		eleUsername.sendKeys("hari.radhakrishnan@qeagle.com");
		
		WebElement elePassword = driver.findElement(By.id("password"));
		elePassword.sendKeys("Testleaf$321");
		
		WebElement eleLogin = driver.findElement(By.id("Login"));
		eleLogin.click();

	}

}