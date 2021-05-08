package apps.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.support.PageFactory;

import amazonDemoApp.BaseClass;
import amazonDemoApp.Log;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductListPage {
	
	private static AndroidDriver driver;
	BaseClass baseClass; 
	
	public ProductListPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		baseClass=new BaseClass(driver);
	}
	
	@AndroidFindBy(xpath = "//*[contains(@resource-id,'rs_results_count_text')]")
	private AndroidElement resultCount;
	@AndroidFindBy(xpath = "//*[contains(@resource-id,'com.amazon.mShop.android.shopping:id/item_title')]")
	private List<AndroidElement> productList;
	@AndroidFindBy(xpath = "//*[contains(@text,'Use my current location')]")
	private AndroidElement currentLocation;
	
	
	
	
	public void selectProduct(String tv) throws InterruptedException {
		/*
		 * if(currentLocation.isDisplayed()) { baseClass.tabByCordinate(driver); }
		 */
		Thread.sleep(5000);
		Iterator<AndroidElement> ae=productList.iterator();
		while(ae.hasNext()) {
			AndroidElement prodctLocator=ae.next();
			String productName=prodctLocator.getText();
			if(productName.contains(tv)) {
				prodctLocator.click();
				
			}
		}
		Log.info("Product selected "+tv);
		
	}

}
