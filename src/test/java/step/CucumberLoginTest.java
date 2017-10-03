package step;

import businesobjects.LoginPageBO;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import webdriver.WebDriverSingleton;

public class CucumberLoginTest {
    LoginPageBO page;

    @Given("^user is on gmail login page$")
    public void openGmailPage() {
        page = new LoginPageBO();
    }

    @When("^user enters login ([^\"]*) and press submit$")
    public void typeLogin(String login) {
        page.typeLoginAndSubmit(login);
    }

    @And("^enters password ([^\"]*) and press submit$")
    public void typePassword(String password) {
        page.typePasswordAndSubmit(password);
    }

    @Then("^user successful logged in$")
    public void isUserLoggedIn() {
        Assert.assertTrue(page.isUserLoggedIn());
    }

    @Then("^quit from driver$")
    public void closeDriver() {
        WebDriverSingleton.dropDriver();
    }
}
