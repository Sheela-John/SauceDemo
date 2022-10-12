package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.TestBase;
import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductPage;
import util.TestUtil;

public class ProductPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	ProductPage productPage;
	CartPage cartPage;
	String sheetName = "product";

	public ProductPageTest() {
		super();
	}

	@BeforeMethod()
	public void setUp() {

		loginPage = new LoginPage();
		homePage = new HomePage();
	}
	@DataProvider
	public Object[][] getSauceDemoTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(dataProvider = "getSauceDemoTestData")
	public void verifyproductName(String filter, String pname) throws IOException {
		try {
			productPage=homePage.selectProduct(pname);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
			String name=productPage.getProductName();
			boolean val;
			if(name.equals(pname))
			{
				test.log(LogStatus.PASS, test.addScreenCapture(TestUtil.capture(driver))+ "Test Passed");
				val=true;
			}
			else
			{
				val=false;
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.capture(driver))+ "Test Failed");

			}
			Assert.assertTrue(val);
		
	}
	@Test(dataProvider = "getSauceDemoTestData")
	public void verifyAddToCart(String filter,String pname) throws InterruptedException
	{
		productPage=homePage.selectProduct(pname);
		productPage.addToCart();
	}
}
