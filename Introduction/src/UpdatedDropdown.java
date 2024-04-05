import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		driver.findElement(By.id("divpaxinfo")).click();

		Thread.sleep(2000);
		
		int excutionCount=2;
		
		numberOfAdults(driver, excutionCount);
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		Thread.sleep(1000);

		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		//Checkbox
		System.out.println( driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		Thread.sleep(2000);
		System.out.println( driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

		//Calender current date
		driver.findElement(By.cssSelector("a[class*=ui-state-highlight]")).click();
		
		//Element enabled or read only 
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).isEnabled()) ;
		
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		Thread.sleep(2000);

		
		
		driver.close();
	}

	private static void numberOfAdults(WebDriver driver, int excutionCount) {
		for(int i=0;i<excutionCount;i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}
	}

}
