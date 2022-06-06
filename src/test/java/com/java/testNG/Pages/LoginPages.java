package com.java.testNG.Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.java.testNG.Initiliazer.baseSetup;

public class LoginPages {

	public static WebDriver driver;

	public LoginPages(WebDriver driver) {
		this.driver = driver;
	}


	@FindBy(how = How.ID, using = "id_username")
	public static WebElement emailId;

	public void enterEmailID() throws IOException {
		this.emailId.sendKeys(baseSetup.getPropertyData("username"));
	}

	@FindBy(how = How.ID, using = "id_password")
	public static WebElement password;

	public void enterPassword() throws IOException {
		this.password.sendKeys(baseSetup.getPropertyData("password"));
	}

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Login')]")
	public static WebElement login;

	public void loginButton() throws IOException {
		this.login.click();
	}

}
