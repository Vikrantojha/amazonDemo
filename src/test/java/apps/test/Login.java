package apps.test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import amazonDemoApp.BaseClass;
import amazonDemoApp.DriverClass;
import amazonDemoApp.Utils;
import amazonDemoApp.Log;
import apps.pages.CartPage;
import apps.pages.HomePage;
import apps.pages.LoginPage;
import apps.pages.ProductListPage;
import apps.pages.ProductPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Login{
	
	String product_name;
	String product_price;
	
	
	
	//BaseClass baseClass = new BaseClass();
	LoginPage loginPage;
	Utils generalFuntion;
	HomePage homePage;
	ProductPage productPage;
	CartPage cartPage;
	DriverClass driverClass=new DriverClass();
	ProductListPage productListPage;
	String propertyFileName = "config.properties";
	Log log=new Log();
	
	/*
	 * public Login() { // super(driver); AndroidDriver
	 * driver=driverClass.getAndroidDriver(); loginPage = new LoginPage(driver);
	 * generalFuntion = new GeneralFuntion();
	 * 
	 * 
	 * }
	 */
	
	@Test(priority=1)
	public void loginToApplicaiton_TC() throws InterruptedException {
		AndroidDriver driver=driverClass.getAndroidDriver();
		loginPage = new LoginPage(driver);
		generalFuntion = new Utils();
		productPage=new ProductPage(driver);
		
		
		try {
			log.info("Login into the application");
			loginPage.loginToApplication(generalFuntion.readValueFromPropertyFile("userName"),
					generalFuntion.readValueFromPropertyFile("password"));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	@Test(priority=2)
	public void HomePageTest_TC() throws InterruptedException, IOException {
		
		homePage = loginPage.validateUserIsLogedIn();
		homePage.enterProductToSearch(generalFuntion.readValueFromPropertyFile("product"));
		
		productListPage=homePage.validateSearchResult();
		
		
	}
	
	@Test(priority=3)
	public void ProductListPage_TC() throws InterruptedException, IOException {
		
		productListPage.selectProduct(generalFuntion.readValueFromPropertyFile("selectProduct"));
		 product_name=productPage.getProductName();
		 //product_price=productPage.getPrice();
		productPage.addToCart();
		cartPage = productPage.proceddToCartPage();
		
	}
	
	@Test(priority=3)
	public void cartPage_TC() throws InterruptedException, IOException {
		
		cartPage.validateProductInCarPage(product_name);
		
		
	}

}
