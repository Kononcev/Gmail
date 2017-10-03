package businesobjects;

import pages.HomePage;

public class HomePageBO{
    private HomePage homePage;

    public HomePageBO() {
        this.homePage = new HomePage();
    }

    public void clickOnComposeButton(){
        homePage.pushCompose();
    }

    public void createNewMessage(String targetMail, String subject, String message){
        homePage.inputTargetMail(targetMail);
        homePage.inputSubject(subject);
        homePage.inputTextMessage(message);
    }
    public void closeMessageWindow(){
        homePage.closeMessage();
    }

    public void openDraftMessagePage(){
        homePage.openDraftMessages();
    }

    public boolean isDraftMessageExist(){
        return homePage.hasDraftMessage();
    }

    public String getFirstDraftMessageSubject(){
        return homePage.getFirstDraftMessageSubject();
    }

    public void sendFirstMessageFromDraft(){
        homePage.openFirstDraftMessage();
        homePage.sendMessageFromDraft();
    }
}
