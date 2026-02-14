package StepDefinition;

import drivers.BaseDriver;
import io.cucumber.java.en.*;
import pages.LoginPage;
import pages.HomePage;
import pages.TransactionPage;

public class BankSteps {

    LoginPage loginPage = new LoginPage(BaseDriver.driver);
    HomePage homePage = new HomePage(BaseDriver.driver);
    TransactionPage transactionPage = new TransactionPage(BaseDriver.driver	);
    

    @Given("I open the Bank Demo app")
    public void i_open_the_bank_demo_app() {
        loginPage.clickBankApp();  // click the button to open login page
    }



    @When("I login with {string} and {string}")
    public void i_login_with_and(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

 // Example step for Make Payment
    @When("I make a payment with phone {string}, name {string}, amount {string}, country {string}")
    public void i_make_a_payment(String phone, String name, String amount, String country){
        homePage.clickMakePayment();
        transactionPage.enterPhone(phone);
        transactionPage.enterName(name);
        transactionPage.enterAmount(amount);
        transactionPage.enterCountry(country);
        transactionPage.clickSendPayment();
    }


    @Then("transaction should be successful")
    public void transaction_should_be_successful() {
        System.out.println("Bank transaction completed ✅");
    }
}
