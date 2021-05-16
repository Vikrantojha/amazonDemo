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
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utils {
	
	String propertyFileLocation;
	String fileName;
	public static AndroidElement mobileElement;
	
	public Utils(String fileName) {
		this.fileName = fileName;
		propertyFileLocation =System.getProperty("user.dir");
	}
	public String readValueFromPropertyFile(String fileName,String propertyName) throws IOException {
		this.fileName=fileName;
		String propertyFile=propertyFileLocation+"\\"+fileName;;
		Properties prop = null;
		try{
			InputStream configReder =new FileInputStream(propertyFile);
			 prop=new Properties();
			prop.load(configReder);
			
		}catch(FileNotFoundException ex) {
			ex.getMessage();
		}
		String val=prop.getProperty(propertyName);

		return prop.getProperty(propertyName);
	}
	
	
	
}
