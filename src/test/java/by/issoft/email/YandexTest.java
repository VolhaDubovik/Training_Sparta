package by.issoft.email;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.experimental.Accessors;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;


public class YandexTest {


    private static final String filePath = "src/test/resources/emailTestData.json";

    LoginYandexPage loginYandexPage = new LoginYandexPage();
    MailYandexPage mailYandexPage = new MailYandexPage();
    AvatarPopUp avatarPopUp = new AvatarPopUp();

    @Data
    public static class EmailData{
        List<Message> messages;

        public List<Message> getMessages() {
            return messages;
        }

        public void setMessages(List<Message> messages) {
            this.messages = messages;
        }

    }

    @Data
    public static class Message{
        String recipient;
        String subject;
        String textBody;

        public String getRecipient() {
            return recipient;
        }

        public void setRecipient(String recipient) {
            this.recipient = recipient;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getTextBody() {
            return textBody;
        }

        public void setTextBody(String textBody) {
            this.textBody = textBody;
        }
    }

    static ObjectMapper mapper = new ObjectMapper();

    private static EmailData getEmailData() throws IOException {
        EmailData emailData = mapper.readValue(Paths.get(filePath).toFile(), EmailData.class);
        return emailData;
    }

    @DataProvider
    public Object[][] message() throws IOException { // message

        EmailData emailData = getEmailData();
        Object[][] messageData = new Object[emailData.getMessages().size()][1];
        for (int i = 0; i < emailData.getMessages().size(); i++) {
            Message m = emailData.getMessages().get(i);
            messageData[i][0] = m;
        }

        return messageData;
    }

    @BeforeMethod
    public void clearCache() {
        clearBrowserCache();
    }

    @Test(dataProvider = "message")
    public void checkEmail(Message message) {


        open("https://mail.yandex.by/");
        loginYandexPage.login("volha.dubovik", "0Defects");

        mailYandexPage.sendNewLetter(message.getRecipient(), message.getSubject(), message.getTextBody());
        //$(withText("Message sent")).shouldBe(Condition.visible);
        mailYandexPage.openUnreadLetter();

        //работает через раз, но всегда что-то падает
        SoftAssert softAssert = new SoftAssert();

        //mailYandexPage.bodyReceivedEmail.waitUntil(Condition.appear, 4000);

        softAssert.assertTrue(mailYandexPage.isLetterReceivedByBody(message.getTextBody()), "There is no email with such body");
        //mailYandexPage.subjectReceivedEmail.waitUntil(Condition.appear, 4000);

        softAssert.assertTrue(mailYandexPage.isLetterReceivedByTitle(message.getSubject()), "There is no email with such subject");

        softAssert.assertAll();

        avatarPopUp.logout();

    }

}







