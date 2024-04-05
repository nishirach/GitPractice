import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeExcercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		System.out.println(driver.findElements(By.tagName("a")).size());
		System.out.println(driver.findElements(By.xpath("//div[@class=' footer_top_agile_w3ls gffoot footer_style']//a")).size());
		System.out.println(driver.findElements(By.xpath("(//table[@class='gf-t']//ul)[1]//a")).size());

		
	}

}
