package Waits;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ExplecitWait {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		String[] names = { "Cucumber", "Beetroot", "Cauliflower", "Orange", "Walnuts", "Strawberry" };
		List<WebElement> items = driver.findElements(By.cssSelector("h4.product-name"));
		int j = 0;
		for (int i = 0; i < items.size(); i++) {
			String[] itemName = items.get(i).getText().split("-");
			String formattedName = itemName[0].trim();
			List itemNames = Arrays.asList(names);
			
			if (itemNames.contains(formattedName)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == names.length) {
					break;
				}
			}
		}
		driver.findElement(By.xpath("//a[@class='cart-icon']")).click();
		driver.findElement(By.xpath("//div[@class='action-block']/button")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(6));
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		//validation
		WebElement loader= driver.findElement(By.cssSelector(".promo-btn-loader"));
		wait.until(ExpectedConditions.invisibilityOf(loader));
		WebElement messsage=driver.findElement(By.cssSelector(".promoInfo"));
		String successMessage=messsage.getText();		
		 wait.until(ExpectedConditions.elementToBeClickable(messsage));
		Assert.assertEquals(successMessage, "Code applied ..!");
		System.out.println(successMessage);

	}

}
