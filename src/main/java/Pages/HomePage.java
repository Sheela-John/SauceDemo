package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(className = "product_sort_container")
	WebElement filterDropDown;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void productSearch(String fdropdown) throws InterruptedException {
		Thread.sleep(3000);

		Select select = new Select(driver.findElement(By.className("product_sort_container")));
		select.selectByVisibleText(fdropdown);

	}

	public ProductPage selectProduct(String pName) throws InterruptedException {

		Thread.sleep(3000);

		List<WebElement> product = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		System.out.println(product.size());
		for (int i = 0; i <= product.size() - 1; i++) {
			String productname = product.get(i).getText();

			if (productname.equals(pName)) {
				product.get(i).click();
				break;
			}
		}
		return new ProductPage();
	}
}