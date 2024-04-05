import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String buttonName =  driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText();
		System.out.println(buttonName);
		String buttonLoginName =  driver.findElement(By.xpath("//header/div/a/parent::div/button[2]")).getText();
		System.out.println(buttonLoginName);
		
		driver.close();
	}

}
