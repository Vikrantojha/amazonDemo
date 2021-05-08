package apps.test;

import java.io.IOException;

import org.testng.annotations.Test;

import amazonDemoApp.BaseClass;
import amazonDemoApp.DriverClass;
import amazonDemoApp.Utils;
import apps.pages.HomePage;
import apps.pages.LoginPage;
import io.appium.java_client.android.AndroidDriver;

public class HomeTest {
	BaseClass baseClass;
	HomePage homePage;
	LoginPage loginPage;
	DriverClass driverClass=new DriverClass();
	
	@Test
	public void loginToApplicaiton() throws InterruptedException, IOException {
		AndroidDriver driver=driverClass.getAndroidDriver();
		loginPage=new LoginPage(driver);
		homePage = loginPage.validateUserIsLogedIn();
		Utils generalFuntion;
		generalFuntion = new Utils();
		
		
		homePage.validateUserIsLogedIn();
		homePage.enterProductToSearch(generalFuntion.readValueFromPropertyFile("product"));
	//	((AndroidDriver)driver).pressKeyCode
	}

}
