package com.test.testApp;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

public class MainClass {

	public static void main(String[] args) {

		final Logger logger = LogManager.getLogger(MainClass.class);

		/*
		 * Chromedriver.exe -> third party driver file by Chrome to invokes chrome
		 * browser to invoke we can either use below setproperty after installing the
		 * right version chromedriver.exe or bydefault SeleniumManager will take care of
		 * it by downloading and connecting
		 */
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\rinzi\\Documents\\Projects\\chromedriver-win64\\chromedriver.exe");

		// setting Chrome options to browser in headless mode
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--headless=new");

		WebDriver cdriver = new ChromeDriver();
		// WebDriver cdriver = new FirefoxDriver();
		// WebDriver cdriver = new EdgeDriver();
		// cdriver.get("https://rahulshettyacademy.com/locatorspractice/");

		// To maximize the window
		cdriver.manage().window().maximize();
		
		//load the page
		cdriver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
		logger.debug("Title is: " + cdriver.getTitle());
		logger.debug("URL is: " + cdriver.getCurrentUrl());
		// logger.trace("pagesource is: " + cdriver.getPageSource());
		logger.debug("windowHandle is: " + cdriver.getWindowHandle());
		// get webdriver session id
		SessionId s = ((RemoteWebDriver) cdriver).getSessionId();
		logger.debug("Session Id is: " + s);

		// cdriver.close(); // closes only the current open window

		// implicit wait
		cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		TestPortal test = new TestPortal();
		test.practiceForm(cdriver);
		test.loginForm(cdriver);

		// Testing Locators
		// Locators loc = new Locators();
		// loc.testLoc(cdriver);

		// cdriver.quit(); // will close all the windows associated
	}

}
