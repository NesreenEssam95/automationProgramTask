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

	@Test(priority=0)
	public void createNewCustomer() throws IOException, InterruptedException, EncryptedDocumentException {
		
	    new HomePage(driver,wait).clickOnBankManagerLogin();
	    new AddCustomerPage(driver,wait).addCustomer().validateCustomerAddedSuccessfully();

	}

	@Test(priority=1)
	public void openNewAccount() throws EncryptedDocumentException {
		
	    new HomePage(driver,wait).clickOnBankManagerLogin();
	    new OpenAccountPage(driver,wait).openNewAccount().validateAccountAddedSuccessfully();

	}

	@Test(priority=2)
	public void searchCustomer() throws IOException, EncryptedDocumentException {
		
	    new HomePage(driver,wait).clickOnBankManagerLogin();
	    new CustomersPage(driver,wait).clickOnCustomerButton().searchCustomer().assertOnCustomerDetails();
	}
	@Test(priority=3)
	public void sortCustomer() throws IOException, EncryptedDocumentException {
		
	    new HomePage(driver,wait).clickOnBankManagerLogin();
	    new CustomersPage(driver,wait).clickOnCustomerButton().sortCustomersDescendingByPostalCode();
		new CaptureScreenShot(driver).ScreenShot(descendingSort);
		new CustomersPage(driver,wait).sortCustomersAscendingByPostalCode();
		new CaptureScreenShot(driver).ScreenShot(ascendingSort);
	    
	}
	
	@Test(priority=4)
	public void deleteCustomer() throws IOException, EncryptedDocumentException {
		
	    new HomePage(driver,wait).clickOnBankManagerLogin();
	    new CustomersPage(driver,wait).clickOnCustomerButton().deleteCustomerSuccessfully();
		new CaptureScreenShot(driver).ScreenShot(deletedCustomer);
	    
	}
}
