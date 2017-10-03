package pages;

import decorator.Button;
import decorator.InputBox;
import decorator.Label;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {
    @FindBy(xpath = "//div[contains(@jscontroller,'DUNnfe')]//div[contains(@role,'button')]")
    private Button composeButton;

    @FindBy(name = "to")
    private InputBox targetMail;

    @FindBy(name = "subjectbox")
    private InputBox messageSubject;

    @FindBy(className = "editable")
    private InputBox messageText;

    @FindBy(className = "Ha")
    private Button closeMessage;

    @FindBy(xpath = "//div[contains(@jscontroller,'DUNnfe')]//div[contains(@role,'navigation')]//a[contains (@href,'#drafts')]")
    private Button openDraftMessages;

    @FindBy(xpath = "//*[@id=\":2\"]/div/div[2]/div[3]/div[1]//tbody/tr")
    private Button firstDraftMessage;

    @FindBy(xpath = "//*[@id=\":2\"]/div/div[2]/div[3]/div[1]//tbody/tr/td[6]//span")
    private Label firstDraftMessageSubject;

    @FindBy(className = "aoO")
    private Button sendButtonFromDraft;

    public HomePage() {
        super();
    }

    public void pushCompose() {
        composeButton.click();
    }

    public void inputTargetMail(String mail) {
        targetMail.sendKeys(mail);
    }

    public void inputSubject(String subject) {
        messageSubject.sendKeys(subject);
    }

    public void inputTextMessage(String message) {
        messageText.sendKeys(message);
    }

    public void closeMessage() {
        closeMessage.click();
    }

    public void openDraftMessages() {
        openDraftMessages.click();
    }

    public boolean hasDraftMessage() {
        return firstDraftMessage.isEnabled();
    }

    public String getFirstDraftMessageSubject() {
        return firstDraftMessageSubject.getText();
    }

    public void openFirstDraftMessage(){
        firstDraftMessage.click();
    }

    public void sendMessageFromDraft() {
        firstDraftMessage.click();
        sendButtonFromDraft.click();
    }
}
