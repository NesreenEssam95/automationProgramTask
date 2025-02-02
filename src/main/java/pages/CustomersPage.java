package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utiles.ReadingCustomerDeatails;

public class CustomersPage {
	WebDriver browserobject;
    WebDriverWait wait;
	
    private static By customer_btn = By.xpath("(//button[@class='btn btn-lg tab'])[3]");//button[contains(.,'Customers')]
	private static By searchCustomer_bar = By.xpath("//input[@placeholder='Search Customer']");
	private static By postalCode = By.xpath("//table//tr/td[3]//a");
	private static By delete_btn = By.xpath("//table//tr[1]/td[5]//button");
	private static By ActualCustomerFirstName_txt = By.xpath("//table/tbody/tr[1]/td[1]");
	private static By ActualCustomerLastName_txt = By.xpath("//table/tbody/tr[1]/td[2]");
	private static By postalCodesElements_txt = By.xpath("//table/tbody/tr/td[3]");

	public CustomersPage(WebDriver browserobject,WebDriverWait wait)
	{
		this.browserobject=browserobject;
		this.wait = wait;
		
	}
     public CustomersPage clickOnCustomerButton()
	
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(customer_btn));
		browserobject.findElement(customer_btn).click();
		return this;
	}
		
	
	public CustomersPage searchCustomer() throws IOException
	
	{
		String serachCustomerFisrtName = ReadingCustomerDeatails.ReadingData(3,1);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchCustomer_bar));
		WebElement custName =browserobject.findElement(searchCustomer_bar);      
		custName.sendKeys(serachCustomerFisrtName);
	

		return this;
		
	}
	
	public CustomersPage assertOnCustomerDetails() throws IOException
	{
		String serachCustomerFirstName = ReadingCustomerDeatails.ReadingData(3,1);
		String serachCustomerLastName = ReadingCustomerDeatails.ReadingData(3,2);
		
		
		String ActualCustomerFirstName= browserobject.findElement(ActualCustomerFirstName_txt).getText().trim();
		 Assert.assertEquals(ActualCustomerFirstName, serachCustomerFirstName);
		
		 String ActualCustomerLastName= browserobject.findElement(ActualCustomerLastName_txt).getText().trim();
		 Assert.assertEquals(ActualCustomerLastName, serachCustomerLastName);

		return this;
		
	}
	
	
	public CustomersPage sortCustomersDescendingByPostalCode() 
	{
		
		 wait.until(ExpectedConditions.visibilityOfElementLocated(postalCode));
			browserobject.findElement(postalCode).click();
			
		
		 ArrayList<String> obtainedList = new ArrayList<>(); 
		 java.util.List<WebElement> elementList= browserobject.findElements(postalCodesElements_txt);
		 for(WebElement we:elementList){
		    obtainedList.add(we.getText());
		 }
		 ArrayList<String> sortedList = new ArrayList<>();   
		 for(String s:obtainedList){
		 sortedList.add(s);
		 }
		 Collections.sort(sortedList);
		 Collections.reverse(sortedList);
		 Assert.assertTrue(sortedList.equals(obtainedList));
		 
		 System.out.println(sortedList);
		 
		return this;	
		
	}
	public CustomersPage sortCustomersAscendingByPostalCode()
	{
		
		 wait.until(ExpectedConditions.visibilityOfElementLocated(postalCode));
			browserobject.findElement(postalCode).click();
			
		
		 ArrayList<String> obtainedList = new ArrayList<>(); 
		 java.util.List<WebElement> elementList= browserobject.findElements(postalCodesElements_txt);
		 for(WebElement we:elementList){
		    obtainedList.add(we.getText());
		 }
		 ArrayList<String> sortedList = new ArrayList<>();   
		 for(String s:obtainedList){
		 sortedList.add(s);
		 }
		 Collections.sort(sortedList);
		 Assert.assertTrue(sortedList.equals(obtainedList));
		 
		 System.out.println(sortedList);
		 
		return this;	
		
	}
	
   public CustomersPage deleteCustomerSuccessfully() throws IOException
	
	{
		String DeleteCustomer = ReadingCustomerDeatails.ReadingData(4,1);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchCustomer_bar));
		WebElement custName =browserobject.findElement(searchCustomer_bar);      
		custName.sendKeys(DeleteCustomer);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(delete_btn));
		browserobject.findElement(delete_btn).click();

		return this;
		
	}

}
