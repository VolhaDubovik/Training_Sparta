package by.issoft.email;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appears;
import static com.codeborne.selenide.Selenide.*;

public class MailYandexPage {

    SelenideElement composeButton = $(".mail-ComposeButton-Text");
    SelenideElement newMessagePopup = $x("//div[@class='composeHeader composeHeader_expanded']/div[@class='composeHeader-Text']");
    SelenideElement toField = $x("//div[@class='MultipleAddressesDesktop ComposeRecipients-MultipleAddressField tst-field-to']//div[@class='composeYabbles']");
    SelenideElement subjectField = $x("//input[@name='subject']");
    SelenideElement emailBody = $(".cke_wysiwyg_div");
    SelenideElement sendButton = $(".ComposeControlPanelButton-Button_action");

    //SelenideElement sentFolder = $("//span[.='Sent']");
    SelenideElement unreadButton = $x("//a[@href='#unread']//span[@class='mail-LabelList-Item_content']");

    SelenideElement fromWhom = $x("//span[@class='mail-MessageSnippet-Item mail-MessageSnippet-Item_sender js-message-snippet-sender']");
    //SelenideElement subjectTitle = $(".mail-MessageSnippet-Item_subject");
   // SelenideElement messageText = $(".mail-MessageSnippet-Item_firstline");

    public void sendNewLetter(String email, String subject, String textBody){
        composeButton.click();
        newMessagePopup.waitUntil(appears,10000);
        toField.setValue(email);
        subjectField.setValue(subject);
        emailBody.setValue(textBody);
        sendButton.click();

    }

    public void openUnreadLetter(){
        unreadButton.click();
        fromWhom.click();
        //subjectTitle.click();
        //messageText.click();

    }

}
