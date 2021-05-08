package amazonDemoApp;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DriverClass {
	
	public static AndroidDriver driver;
	
	public static AndroidDriver getAndroidDriver() {
		try {
			
			DesiredCapabilities caps = new DesiredCapabilities();

			caps.setCapability("platformName", "Android");
			caps.setCapability("platformVersion", "8.1.0");
			caps.setCapability("deviceName", "Moto G5 Plus");
			caps.setCapability("udid", "ZY2245444Q");	
			caps.setCapability("appPackage", "com.amazon.mShop.android.shopping");
			caps.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
	     	caps.setCapability("newCommandTimeout", "60");
	     	caps.setCapability("unicodeKeyboard",true);
	     	caps.setCapability("resetKeyboard",true);
			driver = new AndroidDriver(new URL("http", "0.0.0.0", 4723, "/wd/hub"),caps);
			driver.rotate(ScreenOrientation.PORTRAIT );
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Dimension screenSize = driver.manage().window().getSize();
			int hight=screenSize.getHeight();
			int width=screenSize.getWidth();
			//driver.context("NATIVE_APP");
			//driver.manage().window().setSize(new Dimension(hight, width));
			Log.info("Driver initialialized");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return driver;
	}
	
	

}
