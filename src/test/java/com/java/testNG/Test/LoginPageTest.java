package com.java.testNG.Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.java.testNG.Initiliazer.MyOwnListernersTest;
import com.java.testNG.Initiliazer.baseSetup;
import com.java.testNG.Pages.LoginPages;

@Listeners(MyOwnListernersTest.class)
public class LoginPageTest extends baseSetup {

	public static WebDriver driver;
	public static LoginPages loginpages;

	@BeforeSuite
	public void launchBrowser() throws IOException {
		if ((driver == null)) {
			driver = baseSetup.customBrowser();
		}
	}

	@Test(priority = 0)
	public void login() throws IOException {
		loginpages = PageFactory.initElements(driver, LoginPages.class);
		loginpages.enterEmailID();
		loginpages.enterPassword();
		loginpages.loginButton();
	}

	@Test(priority = 1)
	public void jQuery() throws IOException {
		String expectedResult = "Google";
		String actualResult = "Gogle";
		driver.get("https://jqueryui.com/autocomplete/");
		Assert.assertEquals(expectedResult, actualResult);
	}

	@AfterSuite
	public void tearDown() {
		System.out.println("Execution Completed");
	}
}
