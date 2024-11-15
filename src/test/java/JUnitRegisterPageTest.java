package test.java;
/*
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.test.util.Constants;

//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)*/
public class JUnitRegisterPageTest {

/*	private static final Logger logger = LogManager.getLogger(JUnitRegisterPageTest.class);
	private static WebDriver driver;

	@BeforeAll
	public static void setUp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(Constants.registerURL);
		// To maximize the window
		driver.manage().window().maximize();
		logger.debug("BeforeTest setup done..");
	}

	@Test
	public void testHeaderMsg() {
		String headertxt = driver.findElement(By.xpath("//form[@id='signupForm']/h1")).getText();
		logger.debug("Text in Header is: " + headertxt);
		assertEquals(headertxt, "Welcome,Register");
	}

	@Test
	@Order(1)
	public void testPlaceholders() {
		String val = driver.findElement(By.id("firstname")).getAttribute("placeholder");
		assertEquals(val, "First Name");
		assertEquals("lastname", driver.findElement(By.id("lastname")).getAttribute("placeholder"),"PlaceHolders verified!");
		logger.debug("PlaceHolders verified!");
	}
	
	@Test
	@Order(2)
	public void testPasswordVisibility() throws InterruptedException {
		WebElement elem=driver.findElement(By.cssSelector("#password"));
		elem.sendKeys("pass123");
		Thread.sleep(2000);
		String val = elem.getText();
		assertEquals("",val,"Password retrieved!");
		logger.debug("Password retrieved!");
	}
	

	@AfterAll
	public static void done() {
		driver.quit();
	}
*/
}
