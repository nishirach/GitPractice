import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TableCalculation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		//List<WebElement> amountElements= driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr/td[4]"));//xpath
		List<WebElement> amountElements=driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)")); //css selector
		int sumValues=0;
		
		System.out.println("Size:"+amountElements.size());
		for(int i=0;i<amountElements.size();i++)
		{
			String value = amountElements.get(i).getText();
			System.out.println(value);
			sumValues =sumValues +  Integer.parseInt(value);
		}
		
		System.out.println(sumValues);

		String expectedAmmount =  driver.findElement(By.className("totalAmount")).getText();
		Assert.assertEquals(Integer.parseInt( expectedAmmount.split(":")[1].trim()), sumValues) ;

	}

}
