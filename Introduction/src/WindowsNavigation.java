import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsNavigation {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // to maximize a window
		
		driver.get("https://www.google.com"); // get exectues till the complete url has been loaded inclufing images and everything
		
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		
		driver.close();
	}
}
