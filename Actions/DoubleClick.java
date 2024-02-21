package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClick {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		Actions a=new Actions(driver);
		WebElement textField=driver.findElement(By.id("twotabsearchtextbox"));
		a.moveToElement(textField).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
	

	}

}
