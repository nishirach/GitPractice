import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalenderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver =new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		
		String monthNum="6";
		String date="15";
		String year = "2022";
		String[] expectedDate = {monthNum,date,year};
		
		driver.findElement(By.xpath("//input[contains(@class,'inputGroup__year')]")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(monthNum)-1).click();
		driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();

		
		//to find actual values enetered or not
		List<WebElement> actualDate = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		for(int i =0;i<actualDate.size();i++)
		{
			System.out.println(actualDate.get(i).getAttribute("value"));
			Assert.assertEquals(actualDate.get(i).getAttribute("value"), expectedDate[i]);
		}
		
				
		//driver.findElement(By.xpath("//input[contains(@class,'inputGroup__month')]")).sendKeys(monthNum);
		//driver.findElement(By.xpath("//input[contains(@class,'inputGroup__day')]")).sendKeys(date);
		//driver.findElement(By.xpath("//input[contains(@class,'inputGroup__year')]")).sendKeys(year);
		
	
	}

}
