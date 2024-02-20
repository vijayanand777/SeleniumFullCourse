package HandlingAlertPopUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AletHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys("Vijayanand");
		driver.findElement(By.id("alertbtn")).click();
		// To get Text
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(5000);
		// To accept Alert
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
		driver.findElement(By.id("name")).sendKeys("Vijayanand");
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(5000);
		// To cancel alert
		driver.switchTo().alert().dismiss();

		driver.close();

	}

}
