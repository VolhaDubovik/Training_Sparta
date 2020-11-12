package by.issoft.email;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.appears;
import static com.codeborne.selenide.Selenide.*;

public class MailYandexPage {

    SelenideElement composeButton = $x("//a[contains(@class,'mail-ComposeButton')]");
    SelenideElement newMessagePopup = $x("//div[@class='composeHeader composeHeader_expanded']/div[@class='composeHeader-Text']");
    SelenideElement toField = $x("//div[@class='MultipleAddressesDesktop ComposeRecipients-MultipleAddressField tst-field-to']//div[@class='composeYabbles']");
    SelenideElement subjectField = $x("//input[@name='subject']");
    SelenideElement emailBody = $(".cke_wysiwyg_div");
    SelenideElement sendButton = $(".ComposeControlPanelButton-Button_action");

    SelenideElement unreadButton = $("a[data-title='Unread'] .mail-LabelList-Item_content");
    SelenideElement refreshButton = $(".mail-ComposeButton-Refresh");
    SelenideElement unreadCheckbox = $(".mail-MessageSnippet-Checkbox-Nb");

    SelenideElement unreadLetter = $x("//body/div[2]/div[5]/div[1]/div[3]/div[3]/div[2]/div[5]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]/div[1]/span[2]");
    SelenideElement subjectReceivedEmail = $(".mail-Message-Toolbar-Subject");
    SelenideElement bodyReceivedEmail = $(".ns-view-message-body");


    public void sendNewLetter(String email, String subject, String textBody){
        composeButton.click();
        newMessagePopup.waitUntil(appears,4000);
        toField.setValue(email);
        subjectField.setValue(subject);
        emailBody.setValue(textBody);
        sendButton.click();

    }

    public void openUnreadLetter(){
        refreshButton.click();
        unreadButton.click();
        //unreadCheckbox.waitUntil(appears, 6000);
        unreadLetter.click();
    }

    public boolean isLetterReceivedByTitle(String subject){
        openUnreadLetter();
        return subjectReceivedEmail.getText().equals(subject);
    }

    public boolean isLetterReceivedByBody(String textBody){
        openUnreadLetter();
        return bodyReceivedEmail.getText().equals(textBody);
    }

}
