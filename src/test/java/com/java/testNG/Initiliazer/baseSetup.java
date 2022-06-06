package com.java.testNG.Initiliazer;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class baseSetup {
	public static WebDriver driver;

	public static WebDriver customBrowser() throws IOException {
		String browser = getPropertyData("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\LENOVO\\EclipseWorkSpace\\TestNGPOM\\src\\test\\resources\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();

			driver.get(getPropertyData("URL"));
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\LENOVO\\EclipseWorkSpace\\TestNGPOM\\src\\test\\resources\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();

			driver.get(getPropertyData("URL"));
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		}
		return driver;

	}

	public static String getPropertyData(String key) throws IOException {

		String value;
		FileReader fr = new FileReader(
				"C:\\Users\\LENOVO\\EclipseWorkSpace\\TestNGPOM\\src\\test\\resources\\PropertyFileReader\\testData.Properties");

		Properties p = new Properties();
		p.load(fr);
		value = p.getProperty(key);

		return value;

	}

}
