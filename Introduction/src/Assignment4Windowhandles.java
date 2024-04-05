import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment4Windowhandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.cssSelector("a[href='/windows']")).click();
		
		
		//After click, redirects in same window
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("a[href='/windows/new']"))));
		driver.findElement(By.cssSelector("a[href='/windows/new']")).click();
		
		//Switching to child window
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		String parentWin = itr.next();
		String childWin = itr.next();
		
		driver.switchTo().window(childWin);
		
		System.out.println(driver.findElement(By.cssSelector("h3")).getText());
		
		//Switching to parent window
		driver.switchTo().window(parentWin);		
		System.out.println(driver.findElement(By.cssSelector("h3")).getText());
		driver.quit();
	}

}
