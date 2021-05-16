package apps.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import amazonDemoApp.BaseClass;
import amazonDemoApp.Utils;
import amazonDemoApp.Log;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage{
	
	private static AndroidDriver driver;
	
	BaseClass baseClass;
	
	@AndroidFindBy(xpath="//*[contains(@text,'Already a customer')]")
	private AndroidElement signIn_Btn;
	@AndroidFindBy(xpath="//*[contains(@resource-id,'ap_email_login')]")
	private AndroidElement userName_txt;
	@AndroidFindBy(xpath="//*[contains(@text,'Continue')]")
	private AndroidElement countiue_Btn;
	@AndroidFindBy(xpath="//*[contains(@resource-id,'ap_password')]")
	private AndroidElement password_txt;
	@AndroidFindBy(xpath="(//*[contains(@text,'Sign-In')])[last()]")
	private AndroidElement submit_Btn;
	@AndroidFindBy(xpath="//*[contains(@resource-id,'action_bar_burger_icon')]")
	private AndroidElement hamBurgerMenu;
	@AndroidFindBy(xpath="//*[contains(@text,'Hello')]")
	private AndroidElement logedIn_txt;
	
	public LoginPage(AndroidDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		baseClass=new BaseClass(driver);
	}
	
	
	
	public void loginToApplication(String userName, String password) throws InterruptedException {
		
		baseClass.clickOnElement(driver, signIn_Btn);
		
		userName_txt.sendKeys(userName);
		countiue_Btn.click();
		
		password_txt.sendKeys(password);
		submit_Btn.click();
		Log.info("Login into the application completed");
		
	}
	public HomePage validateUserIsLogedIn() {
		hamBurgerMenu.click();
		
		Assert.assertEquals(logedIn_txt.getText(), "Hello, Testing"); //
		Log.info("Login suffessful");
		return new HomePage(driver);
	}
}
