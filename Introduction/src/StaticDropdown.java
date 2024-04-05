import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;

public class StaticDropdown {

	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		WebElement currencyElement = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select currencyDropdown = new Select(currencyElement);
		currencyDropdown.selectByIndex(3);
		System.out.println( currencyDropdown.getFirstSelectedOption().getText());
		currencyDropdown.selectByVisibleText("INR");
		System.out.println( currencyDropdown.getFirstSelectedOption().getText());
		currencyDropdown.selectByValue("AED");
		System.out.println( currencyDropdown.getFirstSelectedOption().getText());

		driver.close();
	}
			
}
