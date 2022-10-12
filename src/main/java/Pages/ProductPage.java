package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class ProductPage extends TestBase {

	@FindBy(xpath = "//button[@class='btn btn_primary btn_small btn_inventory']")
	WebElement addToCartBtn;
	@FindBy(xpath = "//div[@class='inventory_details_name large_size']")
	WebElement productName;

	public ProductPage() {
		PageFactory.initElements(driver, this);
	}

	public String getProductName() {
		return productName.getText();
	}

	public CartPage addToCart() throws InterruptedException {
		Thread.sleep(3000);

		addToCartBtn.click();
		return new CartPage();
	}
}
