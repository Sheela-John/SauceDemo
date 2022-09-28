package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.LogStatus;

import Base.TestBase;
import Pages.HomePage;
import Pages.LoginPage;
import util.TestUtil;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {

		loginPage = new LoginPage();

	}

	@Test
	public void loginTest() throws IOException {

		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String url = driver.getCurrentUrl();
		boolean val = false;
		if (url.equals("https://www.saucedemo.com/inventory.html")) {
			val = true;
			test.log(LogStatus.PASS, test.addScreenCapture(TestUtil.capture(driver))+ "Test Passed");

		} else {
			val = false;
			test.log(LogStatus.PASS, test.addScreenCapture(TestUtil.capture(driver))+ "Test Passed");

		}
		Assert.assertTrue(val);
	}
}