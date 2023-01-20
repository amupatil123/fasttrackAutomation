package StepDefination;

import java.io.IOException;

import org.checkerframework.checker.guieffect.qual.UI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import KeyWords.UIKeyWords;
import KeyWords.Wait;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStep {
	
	@Given("Browser Should be Open")	
	public void browseropen() {
		UIKeyWords.BrowserOpen("Chrome");
	}
	@And("URL is Launched")
	public void geturl() {
		UIKeyWords.getURL("https://opensource-demo.orangehrmlive.com");
	}
	@When("Verified Login Page Title")
	public void asserttitle() {
		UIKeyWords.asserEqual("OrangeHRM");
	}
	@Then("Browser Closed")
	public void browserclose() {
		UIKeyWords.BrowserClose();
	}
	@Given("Enter Valid Username and Password")
	public void EnterValidUsernameAndPassword() {
		Wait.ExplicitlyWait(By.xpath("//input[@name='username']"));
		UIKeyWords.SendKeys(By.xpath("//input[@name='username']"), "Admin");
		Wait.ExplicitlyWait(By.xpath("//input[@name='password']"));
		UIKeyWords.SendKeys(By.xpath("//input[@name='password']"), "admin123");
	}
	@Given("Click on LoginButton")
	public void ClickOnLogoutButton() {
		Wait.ExplicitlyWait(By.xpath("//button[@type='submit']"));
		UIKeyWords.ClickMe(By.xpath("//button[@type='submit']"));
	}
	@Then("Take Screenshots")
	public void takeScreenshots() throws IOException, InterruptedException {
		UIKeyWords.SeleniumtakeScreenshots("LoginWithValidCred");
	}
	@Then("Click On LogoOutButton")
	public void ClickOnLogoOutBtn() {
		Wait.ExplicitlyWait(By.xpath("//p[@class='oxd-userdropdown-name']"));
		UIKeyWords.ClickMe(By.xpath("//p[@class='oxd-userdropdown-name']"));
		Wait.ExplicitlyWait(By.xpath("//a[text()='Logout']"));
		UIKeyWords.ClickMe(By.xpath("//a[text()='Logout']"));
	}
}