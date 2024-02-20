package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllLocators {
	public static WebDriver driver=new ChromeDriver();
	public static void main(String[] args) {
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
	}
	public static void placeHolder()
	{
		driver.findElement(By.id("inputUsername")).sendKeys("anshika@gmail.com");
		driver.findElement(By.name("inputPassword")).sendKeys("Iamking@000");
	}
	public static void checkBox()
	{
		driver.findElement(By.id("chkboxOne")).click();
	}

}
