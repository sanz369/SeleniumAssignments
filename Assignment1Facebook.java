package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Assignment1Facebook {

	public static void main(String[] args) {
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[@class='_6ltg']/a")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Deepa");
		driver.findElement(By.name("lastname")).sendKeys("Sankar");
		driver.findElement(By.name("reg_email__")).sendKeys("8921757847");
		driver.findElement(By.id("password_step_input")).sendKeys("Abcdef@22");
		
		WebElement eleDay = driver.findElement(By.xpath("//select[@id='day']"));
		Select dayDD = new Select(eleDay);
		dayDD.selectByVisibleText("26");
		
		WebElement eleMonth = driver.findElement(By.id("month"));
		Select monthDD = new Select(eleMonth);
		monthDD.selectByIndex(4);
		
		WebElement eleYear = driver.findElement(By.id("year"));
		Select yearDD = new Select(eleYear);
		yearDD.selectByValue("1988");
		
		driver.findElement(By.xpath("//input[@class='_8esa'][1]")).click();
		

	}

}
