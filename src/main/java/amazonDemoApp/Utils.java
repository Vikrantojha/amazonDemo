package amazonDemoApp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utils {
	
	String propertyFileLocation;
	public static AndroidElement mobileElement;
	
	public Utils() {
		
		propertyFileLocation ="D:\\Learning\\Mobile\\src\\test\\resources\\TestData\\config.properties";
	}
	public String readValueFromPropertyFile(String propertyName) throws IOException {
		String propertyFile=propertyFileLocation;
		Properties prop = null;
		try{
			InputStream configReder =new FileInputStream(propertyFile);
			 prop=new Properties();
			prop.load(configReder);
			
		}catch(FileNotFoundException ex) {
			ex.getMessage();
		}

		return prop.getProperty(propertyName);
	}
	
	
	
	
	
}
