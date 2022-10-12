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

public class CartPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ProductPage productPage;
	CartPage cartPage;
	String sheetName = "product";

	public CartPageTest() {
		super();
	}

	@BeforeMethod()
	public void setUp() {

		loginPage = new LoginPage();
		homePage=new HomePage();
		cartPage=new CartPage();
	}
	@DataProvider
	public Object[][] getSauceDemoTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(dataProvider = "getSauceDemoTestData")
	public void verifyProduct(String filter,String pname) throws InterruptedException, IOException
	{
		
		String name=cartPage.viewProduct(pname);
		boolean val;
		if(name.equals(pname))
		{
			val=true;
			test.log(LogStatus.PASS, test.addScreenCapture(TestUtil.capture(driver))+ "Test Passed");
		}
		else
		{
			val=false;
			test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.capture(driver))+ "Test Failed");

		}
		
		Assert.assertTrue(val);
	}
}
