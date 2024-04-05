import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

public class TakingScreenShots {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	   File scrnsht = 	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE );
	   FileUtils.copyFile(scrnsht,new File("C:\\Users\\nishi\\Screenshot.png"));
	   driver.close();

	}

}
