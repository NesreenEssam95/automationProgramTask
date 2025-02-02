package pages;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utiles.ReadingCustomerDeatails;

public class HomePage {
		
		WebDriver browserobject;
		WebDriverWait wait;
		
        private static By bankManagerlogin_btn = By.xpath("(//div[@class='center']//button)[2]");//button[contains(.,'Bank Manager Login')]
	    private static By email =By.id("email");
	    private static By userName = By.id("username");
	    private static By password = By.id("new-password");
	    private static By agreeBtn = By.id("consent-accept-button");
	    private static By createAccountBtn = By.id("submitBtn");

		
		public HomePage(WebDriver browserobject,WebDriverWait wait)
		{
			this.browserobject=browserobject;
			this.wait = wait;
			
		}
		
		public HomePage navigateTositeurl() throws IOException
		{
			String SiteUrl = ReadingCustomerDeatails.ReadingData(0,1);
			 browserobject.navigate().to(SiteUrl);
			 return this;
			 
		}
		public HomePage clickOnBankManagerLogin()
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(bankManagerlogin_btn));
			browserobject.findElement(bankManagerlogin_btn).click();
			return this;
		}

	}



