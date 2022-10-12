package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class CartPage extends TestBase {

	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	WebElement cartLink;

	public CartPage() {
		PageFactory.initElements(driver, this);
	}

	public String viewProduct(String pName) throws InterruptedException {
		Thread.sleep(4000);
		cartLink.click();
		Thread.sleep(3000);
		String productname = "";
		Thread.sleep(8000);
		List<WebElement> product = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));

		for (int i = 0; i <= product.size(); i++) {
			productname = product.get(i).getText();

			if (productname.equals(pName)) {

				break;
			}
		}
		return productname;

	}
}
