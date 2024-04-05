import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

import org.openqa.selenium.By;

public class RelativeLocatorsEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));
	    System.out.println( driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText() );
	    //another method
		//System.out.println(driver.findElement(RelativeLocator.with(By.tagName("label")).above(nameEditBox)).getText());
	
		WebElement dobLabel = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		String dobInputtext =	driver.findElement(RelativeLocator.with(By.tagName("input")).below(dobLabel)).getAttribute("class");
		driver.findElement(RelativeLocator.with(By.tagName("input")).below(dobLabel)).click();
		System.out.println(dobInputtext);
		//First input was Flex element.Relative locators dont support flex elements,so it gives the subsequent input element values
	
		WebElement chkBxLabel = driver.findElement(By.cssSelector("[for='exampleCheck1']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(chkBxLabel)).click();
		
		WebElement rbTextEle = driver.findElement(By.cssSelector("[for='exampleFormControlRadio1']"));
		driver.findElement(with(By.tagName("input")).toRightOf(rbTextEle)).click();
	
	
	}

}
