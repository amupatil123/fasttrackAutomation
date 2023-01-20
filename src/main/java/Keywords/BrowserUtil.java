package KeyWords;

import java.rmi.Remote;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author prashant.lakudzode This Class contains the BrowserUtil created on dated
 *       10/01/23
 **/
public class BrowserUtil {
	public static RemoteWebDriver driver;
	
	public static void BrowserOpen(String BrowserName) {
		
		if(BrowserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println(BrowserName+"Browser Launched Sucessfully ");
		}
		else if(BrowserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			System.out.println(BrowserName+"Browser Launched Sucessfully ");
		}
		else if(BrowserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println(BrowserName+"Browser Launched Sucessfully ");
		}
		else {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println("Default Browser Launched Sucessfully ");
		}
		}
	public static void BrowserClose() {
		driver.quit();
	}
	public static void getURL(String BrowserName) {
		driver.get(BrowserName);
	}
}
