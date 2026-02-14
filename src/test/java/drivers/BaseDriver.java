package drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseDriver {

    public static AppiumDriver<MobileElement> driver;

    /**
     * Initialize the Appium driver with desired capabilities
     * @throws MalformedURLException if Appium server URL is wrong
     */
    public static void initDriver() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Device and platform details
        caps.setCapability("platformName", "Android");
        caps.setCapability("udid", "5200c707dc88a697");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.expandtesting.practice");
        caps.setCapability("appActivity", ".MainActivity");
        caps.setCapability("adbExecTimeout", 60000); // 60s


        // Initialize driver
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723"), caps);

        // Optional: add implicit wait if needed
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        System.out.println("Appium Driver initialized ✅");
    }

    /**
     * Quit the driver after test completion
     */
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            System.out.println("Appium Driver quit ✅");
        }
    }
}
