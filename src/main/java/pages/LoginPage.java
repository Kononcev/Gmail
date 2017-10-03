package pages;

import decorator.Button;
import decorator.InputBox;
import decorator.Label;
import org.openqa.selenium.support.FindBy;
import utils.ConfigFileHandler;


public class LoginPage extends PageObject {
    @FindBy(name = "identifier")
    private InputBox loginInput;

    @FindBy(id = "identifierNext")
    private Button loginNextButton;

    @FindBy(name = "password")
    private InputBox passwordInput;

    @FindBy(id = "passwordNext")
    private Button passwordNextButton;

    @FindBy(xpath = "//*[@id=\"gb\"]/div[1]/div[1]/div[2]/div[5]/div[1]/a/span")
    private Label userIcon;

    public LoginPage() {
        super();
        driver.get(ConfigFileHandler.getInstance().getGmailURL());
    }

    public void inputLogin(String login) {
        loginInput.sendKeys(login);
    }

    public void inputPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void loginNextButton(){
        loginNextButton.click();
    }

    public void passwordNextButton(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        passwordNextButton.click();
    }

    public boolean userHasLoggedSuccessful() {
        return userIcon.isEnabled();
    }
}
