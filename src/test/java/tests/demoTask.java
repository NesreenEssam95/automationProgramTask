package tests;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;
import pages.AddCustomerPage;
import pages.CustomersPage;
import pages.HomePage;
import pages.OpenAccountPage;
import utiles.CaptureScreenShot;

    public class demoTask extends BaseClass {
	private String descendingSort = "descendingSort.png";
	private String ascendingSort = "ascendingSort.png";
	private String deletedCustomer = "deletedCustomer.png";

	@Test
	public void createNewCustomer() throws IOException, InterruptedException, EncryptedDocumentException {
		
	    new HomePage(driver,wait).clickOnBankManagerLogin();
	    new AddCustomerPage(driver,wait).addCustomer().validateCustomerAddedSuccessfully();
	}

	@Test
	public void openNewAccount() throws EncryptedDocumentException {
		
	    new HomePage(driver,wait).clickOnBankManagerLogin();
	    new OpenAccountPage(driver,wait).openNewAccount().validateAccountAddedSuccessfully();
	}

	@Test
	public void searchCustomer() throws IOException, EncryptedDocumentException {
		
	    new HomePage(driver,wait).clickOnBankManagerLogin();
	    new CustomersPage(driver,wait).clickOnCustomerButton().searchCustomer().assertOnCustomerDetails();
	}
	@Test
	public void sortCustomer() throws IOException, EncryptedDocumentException {
		
	    new HomePage(driver,wait).clickOnBankManagerLogin();
	    new CustomersPage(driver,wait).clickOnCustomerButton().sortCustomersDescendingByPostalCode();
		new CaptureScreenShot(driver).ScreenShot(descendingSort);
		new CustomersPage(driver,wait).sortCustomersAscendingByPostalCode();
		new CaptureScreenShot(driver).ScreenShot(ascendingSort);    
	}	
	@Test
	public void deleteCustomer() throws IOException, EncryptedDocumentException {
		
	    new HomePage(driver,wait).clickOnBankManagerLogin();
	    new CustomersPage(driver,wait).clickOnCustomerButton().deleteCustomerSuccessfully();
		new CaptureScreenShot(driver).ScreenShot(deletedCustomer);
	    
	}
}
