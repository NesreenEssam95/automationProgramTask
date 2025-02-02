package pages;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utiles.CaptureScreenShot;
import utiles.ReadingCustomerDeatails;

public class OpenAccountPage {
	
	WebDriver browserobject;
     WebDriverWait wait;

	private String selectUserFromDropDown="Hermoine Granger";
	private String selectCurrencyFromDropDown="Dollar";
	private String expectedAlertMessage = "Account created successfully with account Number";
	
    private static By openAccount_btn = By.xpath("(//button[@class='btn btn-lg tab'])[2]");//button[contains(.,'Open Account')]
	private static By submitButton_btn = By.xpath("//button[@type='submit']");
	private static By selectUser = By.id("userSelect");
	private static By selectCurrency = By.id("currency");
	
	
	
	public OpenAccountPage(WebDriver browserobject,WebDriverWait wait)
	{
		this.browserobject=browserobject;
		this.wait = wait;
		
	}
	public OpenAccountPage openNewAccount()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(openAccount_btn));
		browserobject.findElement(openAccount_btn).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectUser));
		Select dropdownCustomer = new Select(browserobject.findElement(selectUser));
		dropdownCustomer.selectByVisibleText(selectUserFromDropDown);
		
		Select dropdownCurrency = new Select(browserobject.findElement(selectCurrency));
		dropdownCurrency.selectByVisibleText(selectCurrencyFromDropDown);
	
		browserobject.findElement(submitButton_btn).click();

		return this;
		
	}
	
	public OpenAccountPage validateAccountAddedSuccessfully()  {
		Alert alert = browserobject.switchTo().alert(); // switch to alert
		String actualAlertMessage= browserobject.switchTo().alert().getText(); // capture alert message
		Assert.assertTrue(actualAlertMessage.contains(expectedAlertMessage));
		browserobject.switchTo().alert().accept();
		return this;
	}


}
