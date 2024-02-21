package firstSession;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* Chromedriver.exe -> third party driver file by Chrome to invokes chrome browser
		   to invoke we can either use below setproperty after installing the right version chromedriver.exe
		   or bydefault SeleniumManager will take care of it by downloading and connecting */
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\rinzi\\Documents\\Projects\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver cdriver = new ChromeDriver();
		// WebDriver cdriver = new FirefoxDriver();
		// WebDriver cdriver = new EdgeDriver();
		
		cdriver.get("https://rahulshettyacademy.com/locatorspractice/");
		System.out.println("Title is: " + cdriver.getTitle());
		System.out.println("URL is: " + cdriver.getCurrentUrl());
		System.out.println("pagesource is: " + cdriver.getPageSource());
		// cdriver.close(); // closes only the current open window
//		cdriver.quit(); // will close all the windows associated
		
		// implicit wait
		cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		// Testing Locators
		Locators loc = new Locators();
		loc.testLoc(cdriver);
	}

}
