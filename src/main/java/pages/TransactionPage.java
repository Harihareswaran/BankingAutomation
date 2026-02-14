package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class TransactionPage extends BasePage {
    public TransactionPage(AppiumDriver driver){ super(driver); }

    // Make Payment fields
    By phoneField       = By.id("com.expandtesting.practice:id/phoneTextField");
    By nameField        = By.id("com.expandtesting.practice:id/nameTextField");
    By amountField      = By.xpath("//android.widget.LinearLayout[@resource-id='com.expandtesting.practice:id/makePaymentView']/android.widget.LinearLayout[3]/android.widget.EditText");
    By countryField     = By.id("com.expandtesting.practice:id/countryTextField");
    By sendPaymentBtn   = By.id("com.expandtesting.practice:id/sendPaymentButton");

    // Methods
    public void enterPhone(String phone){ type(phoneField, phone); }
    public void enterName(String name){ type(nameField, name); }
    public void enterAmount(String amount){ type(amountField, amount); }
    public void enterCountry(String country){ type(countryField, country); }
    public void clickSendPayment(){ click(sendPaymentBtn); }
}
