package by.issoft.email;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;


public class YandexTest {

    private static final String filePath = "src/test/resources/emailTestData.json";

    LoginYandexPage loginYandexPage = new LoginYandexPage();
    MailYandexPage mailYandexPage = new MailYandexPage();
    AvatarPopUp avatarPopUp = new AvatarPopUp();

    @BeforeMethod
    public void clearCache() {
        clearBrowserCache();
    }

    @AfterMethod
    protected void afterTest() {
        avatarPopUp.logout();
    }


    @Test(dataProvider = "message", dataProviderClass = EmailDataManager.class)
    public void checkEmail(Message message) {

        Faker faker = new Faker();
        SoftAssert softAssert = new SoftAssert();

        String randomFunnyName = faker.funnyName().name();

        open("https://mail.yandex.by/");
        loginYandexPage.login("volha.dubovik", "0Defects");

        mailYandexPage.sendNewLetter(message.getRecipient(), message.getSubject(), message.getTextBody());
        $(withText("Message sent")).shouldBe(Condition.visible);
        mailYandexPage.openUnreadLetter();

        softAssert.assertEquals(mailYandexPage.getBodyOfReceivedLetter(), message.getTextBody(), "There is no email with such body " + randomFunnyName);
        softAssert.assertEquals(mailYandexPage.getTitleOfReceivedLetter(), message.getSubject(), "here is no email with such subject " + randomFunnyName);

        softAssert.assertAll();

    }

}







