package com.test.testApp;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.util.CaptureTests;

public class TestPortal {

	public final static Logger logger = LogManager.getLogger(TestPortal.class);
	CaptureTests capture = new CaptureTests();

	public void practiceForm(WebDriver cdriver) {
		logger.trace("Inside practiceForm()...");
		
		capture.startTestRecording();
		cdriver.findElement(By.id("name")).sendKeys("Student1");
		cdriver.findElement(By.name("email")).sendKeys("Student1@college.com");
		cdriver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
		cdriver.findElement(By.cssSelector("#mobile")).sendKeys("1122334455");
		cdriver.findElement(By.xpath("//input[@id='dob']")).sendKeys("10/12/1992");
		cdriver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();

		// File upload
		File uploadFileName = new File("pic.png");
		WebElement fileInput = cdriver.findElement(By.cssSelector("input[type=file]"));
		fileInput.sendKeys(uploadFileName.getAbsolutePath());
		// cdriver.findElement(By.id("file-submit")).click();

		logger.debug("uploaded file pic..");

		WebElement addr = cdriver.findElement(By.xpath("//textarea[@id='picture']"));
		addr.sendKeys("12345 asdf st");
		// Get the value entered
		logger.debug("Selected City is: " + addr.getAttribute("value"));
		//capture.takeElementSS(addr, "test_addrField");

		// cdriver.findElement(By.cssSelector("#state")).click();
		cdriver.findElement(By.cssSelector("option[value='Uttar Pradesh']")).click();
		// cdriver.findElement(By.cssSelector("#city")).click(); // Throws element click
		// intercepted: Element is not clickable at point (1025, 679)
		cdriver.findElement(By.cssSelector("option[value='Lucknow']")).click();

		capture.takeSS(cdriver, "test_PracticeForm_screenshot");
		//cdriver.findElement(By.xpath("//form[@class='form-signin validator']/div[last()]/input[1]")).submit();
		capture.stopTestRecording();
		logger.debug("Completed practiceForm!");
	}

	public void loginForm(WebDriver cdriver) {
		logger.trace("Inside loginForm()...");
		//load the page
		cdriver.get("https://www.tutorialspoint.com/selenium/practice/login.php");
				
		/*Wait<WebDriver> w=new WebDriverWait(cdriver, Duration.ofSeconds(10));
		//WebElement elem = (WebElement) w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='login.php']")));
		WebElement elem = cdriver.findElement(By.cssSelector("a[href='login.php']")) ;
		((JavascriptExecutor) cdriver).executeScript("arguments[0].scrollIntoView(true);", elem);
		w.until(ExpectedConditions.visibilityOf(elem));
		elem.click(); */
		
		cdriver.findElement(By.cssSelector("input[placeholder='UserName'")).sendKeys("Student2");
		cdriver.findElement(By.cssSelector("#password")).sendKeys("Student2");
		// take full screenshot and store in project location
		capture.takeSS(cdriver, "test_LoginForm_screenshot");

		//cdriver.findElement(By.linkText("New User")).click();
		logger.debug("Completed loginForm!");
	}
}
