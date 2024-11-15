package test.java;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import com.test.util.Constants;

public class TestNGRegisterPageTest {

	private static final Logger logger = LogManager.getLogger(TestNGRegisterPageTest.class);
	private WebDriver driver;

	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(Constants.registerURL);
		logger.debug("TestNG BeforeTest setup done..");
	}

	@Test(priority = 1)
	public void testHeaderMsg() {
		String headertxt = driver.findElement(By.xpath("//form[@id='signupForm']/h1")).getText();
		logger.debug("Text in Header is: " + headertxt);
		assertEquals(headertxt, "Welcome,Register");
		Reporter.log("Header retrieved from Page was: " + headertxt);
	}
	
	@Test
	public void testPlaceholders() {
		String val=driver.findElement(By.id("firstname")).getAttribute("placeholder");
		assertEquals(val, "First Name");
		assertEquals("lastname",driver.findElement(By.id("lastname")).getAttribute("placeholder"));
		Reporter.log("PlaceHolders verified!");
	}
	
	@Test
	public void testPasswordVisibility() throws InterruptedException {
		WebElement elem=driver.findElement(By.cssSelector("#password"));
		elem.sendKeys("pass123");
		String val = elem.getText();
		assertNotEquals("pass123",val,"Password retrieved!");
		logger.debug("Password retrieved!");
		Reporter.log("Password retrieved!");
	}
	
	@AfterTest
	public void done() {
		logger.debug("All test executed!");
		Reporter.log("All test executed!");
		driver.quit();
	}

}
