import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntroduction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//selenium manager -  for auto comnection to chrome driver
		//For manual call to chrome driver
		//System.setProperty("webdriver.chrome.driver", "C:\\Nishi\\IT-Resources\\Downloads\\chrome-headless-shell-win64\\chrome-headless-shell-win64\\chrome-headless-shell.exe");
				
		//Firefox
		//System.setProperty("webdriver.gecko.driver", "C:\\Nishi\\IT-Resources\\Downloads\\geckodriver-v0.34.0-win64\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		//edge
		//System.setProperty("webdriver.edge.driver", "C:\\Nishi\\IT-Resources\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		//WebDriver driver = new EdgeDriver();

		WebDriver driver = new ChromeDriver();
		//WebDriver Driver = new WebDriver();
		
		driver.get("https://www.linkedin.com");
		System.out.println(driver.getTitle()) ;
		System.out.println(driver.getCurrentUrl());
		driver.close();
	}

}
