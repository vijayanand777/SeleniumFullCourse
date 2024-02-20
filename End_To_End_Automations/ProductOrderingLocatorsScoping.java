package End_To_End_Automations;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProductOrderingLocatorsScoping {
	public static WebDriver driver = new ChromeDriver();

	public static void main(String[] args) throws InterruptedException {

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		selectProducts();
		clickOnKart();
		checkOutProducts();
		enterPromoCode();
		placeOrder();
		selectCountry();
		proceedButton();

	}

	public static void selectProducts(){
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
	public static void clickOnKart()
	{
		driver.findElement(By.xpath("//a[@class='cart-icon']")).click();
		
	}
	public static void checkOutProducts()
	{
		driver.findElement(By.xpath("//div[@class='action-block']/button")).click();
	}
	public static void enterPromoCode() throws InterruptedException
	{
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
	}
	public static void placeOrder()
	{
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
	}
	public static void selectCountry() throws InterruptedException
	{
//		Thread.sleep(1000);
		Select countryName=new Select(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/select")));
		countryName.selectByVisibleText("India");
		driver.findElement(By.cssSelector(".chkAgree")).click();
	}
	public static void proceedButton()
	{
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		String success=driver.findElement(By.cssSelector(".wrapperTwo span")).getText();
		System.out.println(success);
		System.out.println("test passed successfully");
		
		
	}

}
