import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowFunc {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/angularpractice/");

		driver.switchTo().newWindow(WindowType.WINDOW);//WindowType.TAB for tab
		Set<String> windowsOpened = driver.getWindowHandles();
		Iterator<String> it = windowsOpened.iterator();
		String firstWin = it.next();
		String secondWin = it.next();
		driver.switchTo().window(secondWin);
		driver.get("https://courses.rahulshettyacademy.com/courses/");
		String firstCourse = driver.findElements(By.xpath("//div[@class='course-listing-title'][1]")).get(0).getText();
		
		driver.switchTo().window(firstWin);
		WebElement nameEle =driver.findElement(By.cssSelector("[name='name']"));
		nameEle.sendKeys(firstCourse);
		//Getting element screenshot
		File nameElescrn =  nameEle.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(nameElescrn, new File( "C:\\Users\\nishi\\nameElement.png"));
		
		
		//getting height and width of element
		System.out.println( nameEle.getRect().getDimension().getHeight());
		System.out.println( nameEle.getRect().getDimension().getWidth());

		driver.quit();
	}

}
