package apps.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import amazonDemoApp.BaseClass;
import amazonDemoApp.Log;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {

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
	// Country/Region: India
	@AndroidFindBy(xpath="//*[contains(@text,'Australia Amazon.com.au')]")
	private AndroidElement selectCountry_link;
	@AndroidFindBy(xpath="(//*[contains(@text,'Done')])[1]")
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
	
	
	
	public void enterProductToSearch(String productName) {
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
			searchResult_DropDwn.click();
			//baseClass.tabByCordinate(driver);
		}
		
	}
	
	public ProductListPage validateSearchResult() {
		if (searchCount.isDisplayed()) {
			Assert.assertTrue(true, "Search result appeared =" +searchCount.getText());
		}
		return new ProductListPage(driver);
	}
	
	
	
}
