package tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.manager.SeleniumManagerOutput;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utiles.CaptureScreenShot;

public class BaseClass {
	WebDriver driver;
	CaptureScreenShot ScreenShoot;
	WebDriverWait wait;

	@BeforeMethod
	  public void setup() throws IOException 
	 {
		//Initialize WebDriverManager to automatically download the necessary Web driver binary
		 WebDriverManager.chromedriver().clearDriverCache().setup();
		 // Instantiate the chromeDriver
		 driver = new ChromeDriver();
		 wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		 ScreenShoot =new CaptureScreenShot(driver);
		 driver.manage().window().maximize();
		 new HomePage(driver,wait).navigateTositeurl();
	  }

	 @AfterMethod
	  public void tearDown()
	 {
		 driver.close();
	 }

}
