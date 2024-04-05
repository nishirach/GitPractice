import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8AutoSuggestiveDD {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.cssSelector(".ui-autocomplete-input")).sendKeys("ind");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		List<WebElement> autoSuggestions =  driver.findElements(By.cssSelector(".ui-menu-item div"));
		
		
		System.out.println(autoSuggestions.size());
		Thread.sleep(1000);
		for(WebElement suggestion:autoSuggestions)
		{
			String value = suggestion.getText();
			System.out.println(value);
			if(value.equals("India"))
			{
				suggestion.click();
				break;
			}
		}
	}

}
