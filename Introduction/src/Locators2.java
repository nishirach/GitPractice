import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		String userName = "Rahul";
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// TODO Auto-generated method stub
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys(userName);		
		//Regular expression for "starts with" - starts with 'pass' -For CSS
		String name = "rahul";
		String Password = getPassword(driver);
		driver.findElement(By.id("inputUsername")).sendKeys(name);

		driver.findElement(By.name("inputPassword")).sendKeys(Password);

		driver.findElement(By.className("signInBtn")).click();		
		
		System.out.println( driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		System.out.println( driver.findElement(By.cssSelector("div[class*=login] h2")).getText());

		Assert.assertEquals(driver.findElement(By.cssSelector("div[class*=login] h2")).getText(),"Hello "+userName+",");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.close();
	}

	public static String getPassword(WebDriver driver) throws InterruptedException
	{
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String password =  driver.findElement(By.cssSelector("form p")).getText();
		String  returnPassword = password.split("'")[1];
		
		
		return returnPassword;
	}
}
