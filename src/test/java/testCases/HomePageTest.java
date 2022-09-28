package testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.HomePage;
import Pages.LoginPage;
import util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	String sheetName = "product";

	public HomePageTest() {
		super();
	}

	@BeforeMethod()
	public void setUp() {

		loginPage = new LoginPage();
		homePage=new HomePage();
	}

	@DataProvider
	public Object[][] getSauceDemoTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	//@Test(priority = 1, dataProvider = "getSauceDemoTestData")
//	public void verifyFilter(String filter, String pname) {
		//homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	//	try {
			
		//	homePage.productSearch(filter);
		//} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
	//}

	@Test(priority = 1,dataProvider = "getSauceDemoTestData")
	public void verifyselectProduct(String filter, String pname) {
		//homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		try {
			
			homePage.productSearch(filter);
			homePage.selectProduct(pname);
					
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
