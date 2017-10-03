import businesobjects.HomePageBO;
import businesobjects.LoginPageBO;
import model.Message;
import org.testng.annotations.*;
import test.data.DataProviderClass;
import utils.ConfigFileHandler;
import utils.JAXBHandler;
import webdriver.WebDriverSingleton;

import static org.testng.Assert.assertTrue;
@Listeners(TestListener.class)
public class HomePageTest {
    private Message message;

    @BeforeClass
    public void init() {
        message = JAXBHandler.getMessageModelFromXML(ConfigFileHandler.getInstance().getMessageXMLPath());
    }

    @Test(dataProvider = "xmlData", dataProviderClass = DataProviderClass.class)
    public void checkMailInDraft(String login, String password) {
        LoginPageBO loginPageBO = new LoginPageBO();
        HomePageBO homePageBO = new HomePageBO();
        loginPageBO.typeLoginAndSubmit(login);
        loginPageBO.typePasswordAndSubmit(password);
        assertTrue(loginPageBO.isUserLoggedIn());
        homePageBO.clickOnComposeButton();
        homePageBO.createNewMessage(message.getTargetMail(), message.getSubject(), message.getText());
        homePageBO.closeMessageWindow();
        homePageBO.openDraftMessagePage();
        assertTrue(homePageBO.isDraftMessageExist());
        assertTrue(homePageBO.getFirstDraftMessageSubject().equals(message.getSubject()));
        //homePageBO.sendFirstMessageFromDraft();
    }

    @AfterMethod
    public void tearDown() {
        WebDriverSingleton.dropDriver();
    }
}
