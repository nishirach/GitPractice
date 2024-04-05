import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Locator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("inputUsername")).sendKeys("nishi@gmail.com");
		driver.findElement(By.name("inputPassword")).sendKeys("nishi");
		driver.findElement(By.className("signInBtn")).click();
		
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("shre");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("shre@gma.com");
		
		//Parent child Traversing
		//Use indexing as the last resort.Try with other combinations first 
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("shre@gmail.com");
		
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("987465123");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println( driver.findElement(By.cssSelector("form p")).getText());
		
		//driver.findElement(By.className("go-to-login-btn")).click();
		driver.findElement(By.xpath("//div[contains(@class,'pwd-btn')]/button[1]")).click();
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
		
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Rahul");		
		//Regular expression for "starts with" - starts with 'pass' -For CSS
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.id("chkboxOne")).click();
		
		//driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
		//or the same above can be written with contains as		 - For X path
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

		//driver.close();
		}

}
