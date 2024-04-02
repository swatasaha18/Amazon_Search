package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDetailsPage;
import testBase.BaseClass;

public class TC_001_ProductTest extends BaseClass {
	@Test(priority = 1)
	public void verify_product_name() {
		logger.info("***** Starting TC_001_ProductTest *****");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickSearchTextBox();
			logger.info("Clicked on Search box...");
			hp.setSearchValue();
			logger.info("Entered the Product name...");
			hp.clickGoButton();
			logger.info("Clicked on the Go button");

			ProductDetailsPage pdp = new ProductDetailsPage(driver);
			pdp.clickSortBy();
			logger.info("Clicked on SortBy button...");
			pdp.clickHighToLow();
			logger.info("Clicked on Price : High to Low...");

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", pdp.productName);
			js.executeScript("arguments[0].style.border='2px solid red';", pdp.productName);
			js.executeScript("arguments[0].style.border='2px solid red';", pdp.productPrice);

			logger.info("Fetching Product name...");
			String pname = pdp.getProductName();
			System.out.println("Mobile Name and Details : " + pname);
			logger.info("Validating the Product name...");
			Assert.assertEquals(pname, "Samsung Galaxy S24 Ultra 5G AI Smartphone (Titanium Gray, 12GB, 1TB Storage)");
		} catch (Exception e) {
			Assert.fail("An exception occured :" + e.getMessage());
			logger.error("Test failed...");
		}
	}

	@Test(priority = 2)
	public void verify_product_price() {
		try {
			ProductDetailsPage pdp = new ProductDetailsPage(driver);
			logger.info("Fetching Product price...");
			String pprice = pdp.getProductPrice();
			System.out.println("Mobile price ₹ : " + pprice);
			logger.info("Validating the Product price...");
			Assert.assertEquals(pprice, "1,59,990");
			logger.info("***** Finished TC_001_ProductTest *****");
		} catch (Exception e) {
			Assert.fail("An exception occured :" + e.getMessage());
			logger.error("Test failed...");
		}
	}
}
