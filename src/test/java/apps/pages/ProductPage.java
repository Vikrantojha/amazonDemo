package apps.pages;

import java.util.HashMap;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;

import amazonDemoApp.BaseClass;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

public class ProductPage {
	private static AndroidDriver driver;
	BaseClass baseClass;

	@AndroidFindBy(xpath = "//*[contains(@text,'Samsung 163 cm')]")
	private AndroidElement product_name;
	@AndroidFindBy(xpath = "//*[@class='android.widget.EditText' and @text='0.0']")
	private AndroidElement product_price;
	@AndroidFindBy(xpath = "//*[contains(@resource-id,'add-to-cart-button')]")
	private AndroidElement addToCart_Btn;
	@AndroidFindBy(xpath = "//*[@text='Cart']")
	private AndroidElement view_CrtBtn;
	@AndroidFindBy(xpath = "//*[contains(@text,'Use my current location')]")
	private AndroidElement currentLocation;


	public ProductPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		baseClass=new BaseClass(driver);
	}

	public String getProductName() {
		String pn;
		baseClass.tabByCordinate(driver);
		pn = product_name.getText();
		
		return pn;
	}

	public String getPrice() {
		String pp = product_price.getText();
		return pp;
	}

	public void addToCart() {
		
			baseClass.scrollDownToElement();
			addToCart_Btn.click();
		
	}
	
	public CartPage proceddToCartPage() {
		
		view_CrtBtn.click();
		
		return new CartPage(driver);
	}

}
