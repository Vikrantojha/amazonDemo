package apps.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage {
	private static AndroidDriver driver;

	@AndroidFindBy(xpath = "(//*[contains(@text,'Samsung')])[2]")
	private AndroidElement product_name;
	@AndroidFindBy(xpath = "//*[(@text='Cart']")
	private AndroidElement view_CrtBtn;
	@AndroidFindBy(xpath = "//*[contains(@text,'Proceed to checkout')]")
	private AndroidElement proceedChekOut_Btn;
	@AndroidFindBy(xpath = "//*[contains(@text,'DONE')]")
	private AndroidElement done_Btn;
	
	

	
	public CartPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}
	
	public void validateProductInCarPage(String cartproduct) {
		String cartproduct1=product_name.getText();
		Assert.assertEquals(cartproduct, cartproduct1);
	}

}
