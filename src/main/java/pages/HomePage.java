package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    public HomePage(AppiumDriver driver){ super(driver); }

    //By depositBtn       = By.id("com.expandtesting.practice:id/depositBtn");
    //By withdrawBtn      = By.id("com.expandtesting.practice:id/withdrawBtn");
    By makePaymentBtn   = By.id("com.expandtesting.practice:id/makePaymentButton"); // example id

   // public void clickDeposit(){ click(depositBtn); }
    //public void clickWithdraw(){ click(withdrawBtn); }
    public void clickMakePayment(){ click(makePaymentBtn); }
}
