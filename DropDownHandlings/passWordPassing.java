package DropDownHandlings;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

public class passWordPassing {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();//InternetExplorerDriver();//FirefoxDriver();//
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("(//a)[3]")).click();
		Thread.sleep(1000);
		String password=getPassword(driver);
		driver.findElement(By.cssSelector(".go-to-login-btn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("inputUsername")).sendKeys("saagar@gmail.com");
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click(); 
		Thread.sleep(1000);
		String successPopup=driver.findElement(By.tagName("p")).getText();
		System.out.println(successPopup);
		Assert.assertEquals(successPopup, "You are successfully logged in.");
		String userName=driver.findElement(By.tagName("h2")).getText();
		Assert.assertEquals(userName, "Hello saagar@gmail.com,");
		System.out.println(userName);
//		Thread.sleep(10000);
//		driver.close();
		driver.quit();
	}
	public static String getPassword(WebDriver driver) throws InterruptedException
	{
		
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String message=driver.findElement(By.className("infoMsg")).getText();
		String text=message.split("'")[1];
		String password=text.split("'")[0];
		System.out.println(password);
		
         return password;

	}

}
