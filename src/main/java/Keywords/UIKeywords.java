package Keywords;
import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class UIKeywords {
	public static RemoteWebDriver driver;

	public static void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println(browserName + "browser is launched successfully");
		} else if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			System.out.println(browserName + "browser is launched successfully");
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			System.out.println(browserName + "browser is launched successfully");
		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println(browserName + " default browser is launched successfully");

		}
	}

	public static void launchurl(String url) {
		driver.get(url);
		System.out.println("url is launched" + url);
	}

	public static void getTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	public static void closebrowser() {
		driver.close();
		System.out.println("browser is close successfully");
	}

	public static void switchToWindow(String byTitle) {
		String parentWindow = driver.getWindowHandle();
		Set<String> Windows = driver.getWindowHandles();
		// String title=driver.getTitle();
		for (String window : Windows) {
			if (driver.switchTo().window(window).getTitle().equals(byTitle)) {

				System.out.println("swiched on window:-" + byTitle);
				break;
			}
		}

	}

	public static void clickMe(By element) {
		driver.findElement(element).click();
	}

	public static void enterText(By element, String text) {
		driver.findElement(element).sendKeys(text);
	}

	public static void keyboardkeyPress(int keyCode) {
		Robot robo = null;
		try {
			robo = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		robo.keyPress(keyCode);
	}

	public static List<String> getTexts(By element) {
		List<WebElement> elements = driver.findElements(element);
		List<String> texts = new ArrayList<String>();
		for (WebElement elmnt : elements) {
			texts.add(elmnt.getText());
		}
		return texts;
	}

	public static void takeScreenShotsUsingAshot(String testcaseName) throws InterruptedException, IOException {
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("DDmmYYHHmmss");
		LocalDateTime now=LocalDateTime.now();
		String date=dtf.format(now);
		String baseDir=System.getProperty("user.dir");
		
		AShot ashot=new AShot();
		ashot.shootingStrategy(ShootingStrategies.viewportPasting(2000));
		Screenshot srcshot=ashot.takeScreenshot(driver);
		BufferedImage img=srcshot.getImage();
		ImageIO.write(img, "png",new File(baseDir+"\\Screenshots\\"+testcaseName+"___"+".png"));
	}

	public static void mouseMove(By element) {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(element)).build().perform();
	}
	public static void assertequal(String addtitle) {
		String title=driver.getTitle();
		assertEquals(title, addtitle);
	}
	public static void PageDown(int NumberOfDown) throws AWTException, InterruptedException {
		Robot robo=new Robot();
		for(int i=0;i<=NumberOfDown;i++) {
			Thread.sleep(700);
		robo.keyPress(KeyEvent.VK_DOWN);
		robo.keyRelease(KeyEvent.VK_DOWN);
	}
		
	}

}
