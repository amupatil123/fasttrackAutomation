package Features;

import org.openqa.selenium.WebElement;

import Keywords.UIKeywords;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;


public class LoginSteps {
	public WebElement searchbar;
	
	@Given("launch url")
	public void browserOpen() {
		UIKeywords.openBrowser("Chrome");
	}
	@And("pass the url")
	public void urllaunch() {
		UIKeywords.launchurl("https://opensource-demo.orangehrmlive.com/");
	}
}
