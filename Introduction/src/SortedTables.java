import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SortedTables {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.xpath("//th[1]")).click();
		List<WebElement> veggies =  driver.findElements(By.xpath("//tr//td[1]"));
		List<String> actualList = veggies.stream().map(s-> s.getText()).collect(Collectors.toList());
		List<String> expectedList = veggies.stream().map(s-> s.getText()).sorted().collect(Collectors.toList());
		Assert.assertEquals(actualList, expectedList);
		
		//To get price of Beans - //tbody//tr//td[text()='Rice']/following-sibling::td[1]
		List<String> veggiePrice;
		do
		{
		veggiePrice = driver.findElements(By.xpath("//tr//td[1]")).stream().filter(s-> s.getText().contains("Rice")).map(s-> GetVeggiePrice(s)).collect(Collectors.toList());
		veggiePrice.forEach(s -> System.out.println(s));
		if(veggiePrice.size()<1)
		{
			driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
			Thread.sleep(1000);
		}
		}
		while(veggiePrice.size()<1);
			
		
	}

	private static String GetVeggiePrice(WebElement ele) {
		// TODO Auto-generated method stub
		String VeggiePrice = ele.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		return VeggiePrice;
	}
}
