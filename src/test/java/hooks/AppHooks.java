package hooks;

import drivers.BaseDriver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.net.MalformedURLException;

public class AppHooks {

    @Before(order=0)
    public void setupDriver() throws MalformedURLException {
        BaseDriver.initDriver();
        System.out.println("Driver initialized ✅");
    }

    @AfterStep
    public void takeScreenshot(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) BaseDriver.driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
    }

    @After(order=0)
    public void tearDownDriver(){
        BaseDriver.quitDriver();
        System.out.println("Driver quit ✅");
    }
}
