package amazonDemoApp;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

public class BaseClass {

	public static AppiumDriver<MobileElement> driver;
	public static AndroidElement mobileElement;
	public BaseClass(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	public static void clickOnElement(AndroidDriver driver, AndroidElement el) {
		try {
		if(el.isDisplayed()) {
			el.click();
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void scrollDownToElement() {
		
		
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int x = width/2;
		int top_y = (int)(height*0.80);
		int bottom_y = (int)(height*0.20);
		System.out.println("coordinates :" + x + "  "+ top_y + " "+ bottom_y);
		TouchAction ts = new TouchAction(driver);
		 PointOption p1= new PointOption();
		ts.press(p1.point(x, top_y)).moveTo(p1.point(x, bottom_y)).release().perform();
	}
	
	public void tabByCordinate(AndroidDriver driver) {
		this.driver=driver;
		Dimension size = driver.manage().window().getSize();
		  System.out.println(size);
		  //Find endy point which is at top side of screen.
		  int starty = (int) (size.height * 0.20);
		//Find horizontal point 
		  int endy = size.width / 2;
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(PointOption.point(starty, endy)).perform();
	}
	
	public static boolean waitTillTheElementVisiblity(AndroidDriver driver,int waitTime, String el) {
		boolean isElementPresent;
		try{
			mobileElement =  (AndroidElement) driver.findElementByXPath(el);
			WebDriverWait wait = new WebDriverWait(driver, waitTime);
			wait.until(ExpectedConditions.visibilityOf(mobileElement));
			isElementPresent = mobileElement.isDisplayed();
				
		}catch(Exception e){
			isElementPresent = false;
			System.out.println(e.getMessage());
			
		}return isElementPresent;
	}
	
	

	
}
