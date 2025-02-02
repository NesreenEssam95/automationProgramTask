package pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utiles.ReadingCustomerDeatails;

import org.openqa.selenium.Alert;

public class AddCustomerPage {
	WebDriver browserobject;
	WebDriverWait wait;

	private String expectedAlertMessage = "Customer added successfully with customer";
	
    private static By addCustomer_btn = By.xpath("(//button[@class='btn btn-lg tab'])[1]");
	private static By firstName_txt =By.xpath("(//input[@type='text'])[1]");
	private static By lastName_txt = By.xpath("(//input[@type='text'])[2]");
	private static By postalCode_txt = By.xpath("(//input[@type='text'])[3]");
	private static By submitButton_btn = By.cssSelector("button[type='submit']");

	
	
	
	public AddCustomerPage(WebDriver browserobject,WebDriverWait wait)
	{
		this.browserobject=browserobject;
		this.wait = wait;
		
	}

	public AddCustomerPage addCustomer() throws IOException
	{
		
		String firstName = ReadingCustomerDeatails.ReadingData(2, 1);
		String lastName = ReadingCustomerDeatails.ReadingData(2, 2) ;
		String postalCode = ReadingCustomerDeatails.ReadingData(2, 3);
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(addCustomer_btn));
		browserobject.findElement(addCustomer_btn).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(firstName_txt));
		WebElement firstNaame =browserobject.findElement(firstName_txt);      
		firstNaame.sendKeys(firstName); 
	    
		wait.until(ExpectedConditions.visibilityOfElementLocated(lastName_txt));
		WebElement lasttNaame =browserobject.findElement(lastName_txt); 
		lasttNaame.sendKeys(lastName);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(postalCode_txt));
		WebElement postalCoode =browserobject.findElement(postalCode_txt);   
		postalCoode.sendKeys(postalCode); 
		
		browserobject.findElement(submitButton_btn).click();
		

		return this;
		
	}
	public AddCustomerPage validateCustomerAddedSuccessfully()
	{
		Alert alert = browserobject.switchTo().alert(); // switch to alert
		String actualAlertMessage= browserobject.switchTo().alert().getText(); // capture alert message
		 Assert.assertTrue(actualAlertMessage.contains(expectedAlertMessage));
		 browserobject.switchTo().alert().accept();
		return this;
	}
	
	


}
