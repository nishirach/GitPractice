import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCart {
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);
		
		String[] veggies={"Brocolli","Banana","Potato"};
				
		for(String veggie:veggies)
		{
			ClickVeggieAndAddToCart(driver,veggie);
		}

		////h4[text() = 'Cucumber - 1 Kg' ] / parent::div / div[@class='product-action']/button[@type='button']
	}

	private static void ClickVeggieAndAddToCart(WebDriver driver,String veggie) throws InterruptedException {
		//String veggie = "Cucumber";
		String xPathVeggie = "//h4[contains(text() , '"+veggie+"') ]/ parent::div //button[@type='button']";
		//driver.findElement(By.xpath("//h4[contains(text() , 'Cucumber') ]/ parent::div //button[@type='button']")).click();
		driver.findElement(By.xpath(xPathVeggie)).click();
		Thread.sleep(2000	);
	}
}

