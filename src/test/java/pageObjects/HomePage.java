package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.ExcelUtility;

public class HomePage extends BasePage {
	WebDriver driver;
	ExcelUtility xlutil = new ExcelUtility(".\\testData\\DataInputAmazon.xlsx");

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "twotabsearchtextbox")
	WebElement searchTextBox;

	@FindBy(id = "nav-search-submit-button")
	WebElement goButton;

	public void clickSearchTextBox() {
		searchTextBox.click();
	}

	public void setSearchValue() throws IOException {
		String val = xlutil.getCellData("Sheet1", 0, 0);
		searchTextBox.sendKeys(val);
	}

	public void clickGoButton() {
		goButton.click();
	}
}