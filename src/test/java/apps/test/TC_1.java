package apps.test;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import amazonDemoApp.DriverClass;
import amazonDemoApp.Log;
import amazonDemoApp.Utils;
import apps.pages.CartPage;
import apps.pages.HomePage;
import apps.pages.LoginPage;
import apps.pages.ProductListPage;
import apps.pages.ProductPage;
import io.appium.java_client.android.AndroidDriver;

public class TC_1{
	
	String product_name;
	String product_price;
	
	static ExtentTest test;
	static ExtentReports extent;
	static ExtentSparkReporter spark;
	ExtentTest Logger;
	
	LoginPage loginPage;
	Utils generalFuntion;
	HomePage homePage;
	ProductPage productPage;
	CartPage cartPage;
	DriverClass driverClass=new DriverClass();
	ProductListPage productListPage;
	String propertyFileName = "config.properties";
	Log log=new Log();
	
	
	@BeforeClass
	public static void startTest() {
		extent = new ExtentReports();
        spark = new ExtentSparkReporter("target/Extent-Report.html");
        extent.attachReporter(spark);
	}
	
	
	@Test(priority=1)
	public void loginToApplicaiton_TC() throws InterruptedException {
		 Logger= extent.createTest("Login TC","Login to the application");
		
		AndroidDriver driver=driverClass.getAndroidDriver();
		loginPage = new LoginPage(driver);
		generalFuntion = new Utils(propertyFileName);
		productPage=new ProductPage(driver);
		
		
		try {
			
			log.info("Login into the application");
			
			Logger.log(Status.INFO, "Login into the application");
			loginPage.loginToApplication(generalFuntion.readValueFromPropertyFile(propertyFileName,"userName"),
					generalFuntion.readValueFromPropertyFile(propertyFileName,"password"));

			Logger.log(Status.PASS, "Login Successfull ");
			
		} catch (IOException e) {
			Logger.log(Status.FAIL, "Login failed ");
			e.printStackTrace();
		}
	}
	@Test(priority=2)
	public void HomePageTest_TC() throws InterruptedException, IOException {
		 Logger= extent.createTest("Product Search ","Search Product and validat");
		
		 try {
		homePage = loginPage.validateUserIsLogedIn();
		Logger.log(Status.INFO, "User is on Homepage");
		homePage.enterProductToSearch((generalFuntion.readValueFromPropertyFile(propertyFileName,"product")),Logger);
		Logger.log(Status.INFO, "Product search....");
		productListPage=homePage.validateSearchResult();
		Logger.log(Status.INFO, "Search Resule Validated");
		 }catch(Exception ex) {
			 Logger.log(Status.FAIL, "Test fail");
		 }
		
	}
	
	@Test(priority=3)
	public void ProductListPage_TC() throws InterruptedException, IOException {
		
		productListPage.selectProduct(generalFuntion.readValueFromPropertyFile(propertyFileName,"selectProduct"));
		 product_name=productPage.getProductName();
		productPage.addToCart();
		cartPage = productPage.proceddToCartPage();
		
	}
	
	@Test(priority=4)
	public void cartPage_TC() throws InterruptedException, IOException {
		
		cartPage.validateProductInCarPage(product_name);
		
		
	}
	
	@AfterClass
	public static void endTest() {
		extent.flush();
	}

}
