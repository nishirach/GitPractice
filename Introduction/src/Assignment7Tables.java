import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7Tables {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,700)");
		
		js.executeScript("document.querySelector('.table-display').scrollTop = 5000");

		List<WebElement> tableRows=driver.findElements(By.cssSelector(".table-display tr")); //css selector
		System.out.println("No of rows in table :"+ ( tableRows.size()-1)); //as tr also contains table header

		List<WebElement> tableColumns=driver.findElements(By.cssSelector(".table-display th")); 

		System.out.println("No of columns in table :"+  tableColumns.size());
		
		List<WebElement> secondValueRow=driver.findElements(By.cssSelector(".table-display tr:nth-child(3) td"));
		System.out.println("Values in the 2nd row :");
		for(WebElement ele:secondValueRow)
		{
			System.out.println(ele.getText());
		}
			
		
		
	}

}
