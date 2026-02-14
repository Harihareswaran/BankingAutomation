package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    public LoginPage(AppiumDriver driver){
        super(driver);
    }

    By bankAppBtn     = By.id("com.expandtesting.practice:id/btn_bank_app"); // new
    By usernameField  = By.id("com.expandtesting.practice:id/usernameTextField");
    By passwordField  = By.id("com.expandtesting.practice:id/passwordTextField");
    By loginBtn       = By.id("com.expandtesting.practice:id/loginButton");

    // New method to click bank app button
    public void clickBankApp() {
        click(bankAppBtn);
    }

    public void enterUsername(String username){
        type(usernameField, username);
    }

    public void enterPassword(String password){
        type(passwordField, password);
    }

    public void clickLogin(){
        click(loginBtn);
    }
}
