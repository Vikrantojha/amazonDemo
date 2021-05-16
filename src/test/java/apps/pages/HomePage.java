package apps.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import amazonDemoApp.BaseClass;
import amazonDemoApp.Log;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {
	static ExtentTest test;
	static ExtentReports extent;
	static ExtentSparkReporter spark;
	
	ExtentTest Logger= extent.createTest("Login TC","Login to the application");
	private static AndroidDriver driver;
	BaseClass baseClass;
	
	
	
	@AndroidFindBy(xpath="//*[contains(@resource-id,'action_bar_burger_icon')]")
	private AndroidElement hamBurgerMenu;
	@AndroidFindBy(xpath="//*[contains(@text,'Hello')]")
	private AndroidElement logedIn_txt;
	@AndroidFindBy(xpath="//*[contains(@text,'Settings')]")
	private AndroidElement setting_lnk;
	@AndroidFindBy(xpath="//*[contains(@text,'Country')]")
	private AndroidElement country_link;
	@AndroidFindBy(xpath="//*[contains(@text,'Australia Amazon.com.au')]")
	private AndroidElement selectCountry_link;
	@AndroidFindBy(xpath="//*[@text='Done' and @class='android.widget.Button']")
	private AndroidElement done_Btn;
	@AndroidFindBy(xpath="//*[contains(@resource-id,'rs_search_src_text')]")
	private AndroidElement enter_searchTextBox;
	@AndroidFindBy(xpath="//*[contains(@resource-id,'rs_results_count_text')]")
	private AndroidElement searchCount;
	@AndroidFindBy(xpath="(//*[contains(@resource-id,'buttons')])[last()]")
	private AndroidElement cameraBtn;
	@AndroidFindBy(xpath="(//*[contains(@resource-id,'id/iss_search_dropdown_item_text')])[last()]")
	private AndroidElement searchResult_DropDwn;
	
	
	

	public HomePage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		baseClass=new BaseClass(driver);
	
	}
	
	
	public void validateUserIsLogedIn() {
		hamBurgerMenu.click();
		Assert.assertEquals(logedIn_txt.getText(), "Hello, Testing"); //
	}
	
	
	public void selectCountry() {

		country_link.click();
		selectCountry_link.click();
		done_Btn.click();
		
	}
	
	
	
	public void enterProductToSearch(String productName,ExtentTest Logger ) {
		this.Logger=Logger;
		Log.info("searching product "+productName);
		if (enter_searchTextBox.isDisplayed()) {
			cameraBtn.click();
			
			enter_searchTextBox.click();
			try {
			enter_searchTextBox.sendKeys(Keys.ENTER);
			enter_searchTextBox.sendKeys(productName);
			}catch(Exception e) {
				enter_searchTextBox.sendKeys(Keys.ENTER);
				enter_searchTextBox.sendKeys(productName);
			}
			
			if(searchResult_DropDwn.isDisplayed()) {
				searchResult_DropDwn.click();
				Logger.log(Status.PASS, "Product search success");
			}else {
					Logger.log(Status.FAIL, "Product search Failed");
			}
			
			
		}
		
	}
	
	public ProductListPage validateSearchResult() {
		if (searchCount.isDisplayed()) {
			Assert.assertTrue(true, "Search result appeared =" +searchCount.getText());
		}
		return new ProductListPage(driver);
	}
	
	
	
}
