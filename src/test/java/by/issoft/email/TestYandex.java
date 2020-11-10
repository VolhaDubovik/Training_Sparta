package by.issoft.email;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestYandex {

    LoginYandexPage loginYandexPage = new LoginYandexPage();
    MailYandexPage mailYandexPage = new MailYandexPage();

    @Test
    public void loginYandex() {
        open("https://passport.yandex.by/auth?from=mail&origin=hostroot_homer_auth_by&retpath=https%3A%2F%2Fmail.yandex.by%2F%3Fnoretpath%3D1&backpath=https%3A%2F%2Fmail.yandex.by%3Fnoretpath%3D1");
        loginYandexPage.login("volha.dubovik", "********");
        //Assert.assertFalse(loginYandexPage.isLoginPerformedCorreclty());

    }

    @Test
    public void sendEmail() {
        mailYandexPage.sendNewLetter("volha.dubovik@yandex.com", "Hello222", "Test Hello222");
        $(withText("Message sent")).shouldBe(Condition.visible);
    }

    @Test
    public void checkEmail() {
        mailYandexPage.openUnreadLetter();
        String subjectTitle = $(".mail-Message-Toolbar-Subject").getText();
        String messageText = $(".ns-view-message-body").getText();
        Assert.assertEquals(subjectTitle, "Hello222", "There is no email with such subject");
        Assert.assertEquals(messageText, "Test Hello222", "There is no email with such body");

    }

    /*    @DataProvider
    public Object[][] getData() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/resources/45146523.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("dataSet");
        List<TestData> testData = new Gson().fromJson(dataSet, new TypeToken<List<TestData>>() {
        }.getType());
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;
    }*/

/*    @Test(dataProvider = "getData")
    public void testMethod(TestData data) {
        System.out.println(data);
    }*/


}



