import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class URLVerifications {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.manage().window().maximize();

		String urlToCheck = driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
		
		
		List<WebElement> urlsToCheck = driver.findElements(By.cssSelector(".gf-t a"));
		SoftAssert sa = new SoftAssert(); //to continue execution

		for(WebElement currentURL : urlsToCheck)
		{
			String currentHref = currentURL.getAttribute("href");
			if(currentHref != null)
			{
				System.out.println(currentHref);
				//extracted(currentHref);
				HttpURLConnection conn = (HttpURLConnection) new URL(currentHref).openConnection();
				conn.connect();
				int iResponseCode =  conn.getResponseCode();
				System.out.println("Its Response : "+iResponseCode);
				
				//Assert.assertTrue(iResponseCode<400,urlToCheck + " - is a broken link,");//Hart asserr
				sa.assertTrue(iResponseCode<400,urlToCheck + " - is a broken link,"); //soft alert
				
			}
		}
		sa.assertAll();

	}

	
}
