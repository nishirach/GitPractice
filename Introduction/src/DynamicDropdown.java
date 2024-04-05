import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[@value='RDP']")).click();
		Thread.sleep(2000);

		// driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		// if indexes are not permissable
		// Parent-child relationship xpath
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']"))
				.click();
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("a[class*=ui-state-highlight]")).click();
		int x = 5;
		x = x + 2;
		// Element enabled or read only
		System.out.println(driver.findElement(By.id("Div1")).isEnabled());
		// isEnabled element does not work in some websites as the way they've designed
		// is different
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		returnCalenderEnabled(driver);

		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).isEnabled());

		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

		returnCalenderEnabled(driver);

		// driver.close();

	}

	private static void returnCalenderEnabled(WebDriver driver) {
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			System.out.println("enabled");
		} else {
			System.out.println("disabled");

		}
	}

}
