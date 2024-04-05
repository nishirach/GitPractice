import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment6DynamicSelection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("checkBoxOption2")).click();
		String optionSelected = driver.findElement(By.xpath("//input[@id='checkBoxOption2']/parent::label")).getText();
		System.out.println(driver.findElement(By.xpath("//input[@id='checkBoxOption2']/parent::label")).getText());
		
		//Dropdown selection
		driver.findElement(By.xpath("//select")).click();
		for(WebElement dropdownOption : driver.findElements(By.xpath("//select/option")))
		{
			if(dropdownOption.getText().equals(optionSelected.trim()))
			{
				dropdownOption.click();
				driver.findElement(By.xpath("//select")).click();

				break;
			}
		}
		
		//alert mech
		driver.findElement(By.id("name")).sendKeys(optionSelected);
		driver.findElement(By.id("alertbtn")).click();
		driver.switchTo().alert();
		String alertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		if(alertText.contains(optionSelected))
		{
		System.out.println("Alert text contains "+optionSelected);
		}
		else
		{
			{
				System.out.println("Alert text contains does not contain "+optionSelected);
				}
		}
		
		driver.close();
	}

}
