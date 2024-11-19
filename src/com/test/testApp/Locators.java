package com.test.testApp;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Locators {

	public final static Logger logger = LogManager.getLogger(Locators.class);

	public void testLoc(WebDriver cdriver) {
		logger.trace("Inside testLocators...");
		cdriver.findElement(By.id("id")).sendKeys("user1");
		cdriver.findElement(By.name("pass")).sendKeys("pass1");
		cdriver.findElement(By.xpath("//input[@type='submit']")).submit();
		// cdriver.findElement(By.className("signInBtn")).submit();
		// logger.error("Found Error: "
		// +cdriver.findElement(By.cssSelector("p.error")).getText());

		// explicit wait
		Wait<WebDriver> wait = new WebDriverWait(cdriver, Duration.ofSeconds(5));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.error"))); // class="error"
		//if (ExpectedConditions.textToBePresentInElement(element, "Incorrect UserID or Password") != null) {
			System.out.println("Found Error: " + element.getText());
		//}
		/*
		 * .error //cdriver.findElement(By.linkText("Forgot your password?")).click();
		 * // next page // wait for page to be stable // try { // Thread.sleep(1000); //
		 * } catch (InterruptedException e) { // // TODO Auto-generated catch block //
		 * e.printStackTrace(); // }
		 * cdriver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(
		 * "TestUser");
		 * cdriver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys(
		 * "TestUser@email.com"); //
		 * cdriver.findElement(By.cssSelector(".signInBtn")).submit();
		 *
		 * cdriver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		 * cdriver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).
		 * sendKeys("TestUser123@email.com"); // parent child
		 * cdriver.findElement(By.xpath("//form/input[3]")).sendKeys("12345");
		 * cdriver.findElement(By.xpath("//form/input[@type='text'][3]")).clear();
		 * cdriver.findElement(By.cssSelector("form input[placeholder=\"Phone Number\"]"
		 * )).sendKeys("123456789");
		 * cdriver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		 *
		 * String
		 * str[]=cdriver.findElement(By.cssSelector("form p")).getText().split("'");
		 * System.out.println("New password msg: "+str[1]);
		 * cdriver.findElement(By.cssSelector(".go-to-login-btn")).click();
		 * System.out.println("executed findby locators.."); login(cdriver);
		 */
	}

	public void login(WebDriver cdriver) {
		try {
			Thread.sleep(1000);

			System.out.println("Logging in now..");
			cdriver.findElement(By.cssSelector("#inputUsername")).sendKeys("TestUser123");
			cdriver.findElement(By.id("chkboxOne")).click();
			// using regular expressions
			cdriver.findElement(By.cssSelector("input[type*='pass'")).sendKeys("rahulshettyacademy");
			cdriver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
			Thread.sleep(1000);
			String log = cdriver.findElement(By.xpath("//div/div/div/p")).getText();
			Assert.assertEquals(log, "You are successfully logged in.");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
