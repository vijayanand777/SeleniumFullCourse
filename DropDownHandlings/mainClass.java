package DropDownHandlings;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class mainClass {

	public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.get("http://192.168.6.8:3000/login");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.name("emailInput")).sendKeys("saagar@gmail.com");
	driver.findElement(By.name("password")).sendKeys("Vijay@12");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	String text=driver.findElement(By.xpath("//p[text()='Please enter the correct password...']")).getText();
    System.out.println(text);
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(10000);
    driver.close();
    
	}

}   
