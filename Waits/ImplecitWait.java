package Waits;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplecitWait {

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

	}

}
