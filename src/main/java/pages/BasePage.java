package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    AppiumDriver<MobileElement> driver;
    WebDriverWait wait;

    public BasePage(AppiumDriver<MobileElement> driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

    public MobileElement waitAndFind(By locator){
        return (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void click(By locator){
        waitAndFind(locator).click();
    }

    public void type(By locator, String text){
        MobileElement element = waitAndFind(locator);
        element.clear();
        element.sendKeys(text);
    }
}
