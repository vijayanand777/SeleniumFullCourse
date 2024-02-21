package Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LimitingDriverScope {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		int count=driver.findElements(By.tagName("a")).size();
		System.out.println(count);
		WebElement newDriver= driver.findElement(By.id("gf-BIG"));
		System.out.println(newDriver.findElements(By.tagName("a")).size());
		WebElement columnLinks=newDriver.findElement(By.xpath("//table/tbody/tr/td/ul"));
		int counts=columnLinks.findElements(By.tagName("a")).size();
		System.out.println(counts);
		driver.quit();
		

	}

}
