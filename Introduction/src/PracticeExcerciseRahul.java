import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeExcerciseRahul {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement footdriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footdriver.findElements(By.tagName("a")).size());
		
		WebElement tableColumnDriver = footdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(tableColumnDriver.findElements(By.tagName("a")).size());
		
		List<WebElement> leftLinks = tableColumnDriver.findElements(By.tagName("a"));
		
		for(int i=1;i< leftLinks.size();i++)
		{
			String keyCombination =  Keys.chord(Keys.CONTROL,Keys.ENTER);
			leftLinks.get(i).sendKeys(keyCombination);

		}
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		Thread.sleep(5);

		//for(int i=0;i<windows.size();i++)
		while(itr.hasNext())
		{
		driver.switchTo().window(itr.next());
		System.out.println(driver.getTitle()); 
		}
		
		driver.quit();
	}

}
