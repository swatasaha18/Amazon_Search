package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage {
	WebDriver driver;

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "a-autoid-0")
	WebElement sortBy;

	@FindBy(xpath = "//a[@id='s-result-sort-select_2']")
	WebElement highToLow;

	@FindBy(xpath = "//*[@id='search']//div[2]//h2//span")
	public WebElement productName;

	@FindBy(xpath = "//*[@id='search']//a/span/span[2]/span[2]")
	public WebElement productPrice;

	public void clickSortBy() {
		sortBy.click();
	}

	public void clickHighToLow() {
		highToLow.click();
	}

	public String getProductName() {
		return productName.getText();
	}

	public String getProductPrice() {
		return productPrice.getText();
	}
}
