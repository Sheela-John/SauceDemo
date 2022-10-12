package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	public static ExtentReports report;
	public static ExtentTest test;

	@BeforeSuite
	public void startTest() {
		report = new ExtentReports(System.getProperty("user.dir") + "/src/test-output/ExtentReportResults.html");
		test = report.startTest("Demo");
	}

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeTest
	public static void initialization() {
		String browserName = prop.getProperty("browser");

		WebDriverManager.chromedriver().driverVersion("105.0.5195.127").setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}

	@AfterTest
	public void driver_method_close() {
		driver.quit();
	}

	@AfterSuite
	public void tearDown() {
		report.flush();
	}

}
