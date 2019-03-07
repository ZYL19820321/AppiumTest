package utils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.http.util.TextUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;

public class BaseSuite {

	private AndroidDriver driver;
	public TestUtil au;

	@BeforeClass
	public void config() {
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "apps");
		File app = new File(appDir, "kingyee.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("automationName", "Appium");
		capabilities.setCapability("app", "C:\\Users\\Administrator\\Desktop\\togo-debug.apk");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "OnePlus6");
//		capabilities.setCapability("platformVersion", "9.0");
		capabilities.setCapability("sessionOverride", true);
		capabilities.setCapability("noSign","true");
		capabilities.setCapability("noReset","true");
		capabilities.setCapability("fullReset","false");
		capabilities.setCapability("appPackage", "com.togo.apps");
		capabilities.setCapability("appActivity", ".InitActivity");
		capabilities.setCapability("deviceReadyTimeout", "3600");
		capabilities.setCapability("automationName", "uiautomator2");
	
//		capabilities.setCapability("unicodeKeyboard","True");
//		capabilities.setCapability("resetKeyboard","True");
	
		try {
			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			au = new TestUtil(driver);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		au.appWait(5000);
		au.implitilyWait(80);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
	       if (null != driver) {
	    	      driver.quit();
	       }
	}
}
