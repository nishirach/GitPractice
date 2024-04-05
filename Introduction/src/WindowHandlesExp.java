import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandlesExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.className("blinkingText")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Window switching
		Set<String> windows = driver.getWindowHandles();
		
		//Defining Iterator to move through sets
		Iterator<String> itr = windows.iterator();
		//Iterator is initially out of the set  - [parentid,childid]
		//First move iterator inside the set
		String parentID = itr.next();
		String childID = itr.next(); // get child handle details
		driver.switchTo().window(childID);//To switch to child window
		
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".im-para.red"))));
		System.out.println( driver.findElement(By.cssSelector(".im-para.red")).getText());
		String emailID =driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		
		//Switching back to the parent window
		driver.switchTo().window(parentID);
		driver.findElement(By.id("username")).sendKeys(emailID);
	}

}
