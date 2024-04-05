import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3WaitPractise {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();

		WebDriverWait expWaitAlert = new WebDriverWait(driver, Duration.ofSeconds(5));
		expWaitAlert.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("modal-dialog"))));

		driver.findElement(By.id("okayBtn")).click();
		driver.findElement(By.xpath("//option[text()='Consultant']")).click();
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();

		WebDriverWait expWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		expWait.until(ExpectedConditions.urlToBe("https://rahulshettyacademy.com/angularpractice/shop"));
		System.out.println("Page opened");
		// driver.manage().window().maximize();
		List<WebElement> addButtons = driver.findElements(By.className("btn-info"));
		System.out.println(addButtons.size());
		for (WebElement addButton : addButtons) {
			addButton.click();
			// Thread.sleep(1000);
		}

		driver.findElement(By.className("btn-primary")).click();

		WebDriverWait checkOutWait = new WebDriverWait(driver, Duration.ofSeconds(5));

		checkOutWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("btn-success"))));
		driver.close();
	}
}
