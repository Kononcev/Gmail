package businesobjects;

import pages.LoginPage;

public class LoginPageBO{
    private LoginPage loginPage;

    public LoginPageBO() {
        this.loginPage = new LoginPage();
    }

    public void typeLoginAndSubmit(String login) {
        loginPage.inputLogin(login);
        loginPage.loginNextButton();
    }

    public void typePasswordAndSubmit(String password) {
        loginPage.inputPassword(password);
        loginPage.passwordNextButton();
    }

    public boolean isUserLoggedIn(){
        return loginPage.userHasLoggedSuccessful();
    }
}
