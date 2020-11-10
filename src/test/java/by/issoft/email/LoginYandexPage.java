package by.issoft.email;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appears;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginYandexPage {

    SelenideElement login = $x("//input[@id='passp-field-login']");
    SelenideElement submitButton = $(".Button2_view_action");
    SelenideElement password = $x("//input[@id='passp-field-passwd']");

    SelenideElement mainPage = $x("//div[@class='mail-App-Content js-mail-app-content']");

    public void login(String loginValue, String passwordValue){

        login.setValue(loginValue);
        submitButton.click();
        password.waitUntil(appears, 40000);
        password.setValue(passwordValue);
        submitButton.click();

    }

    public boolean isLoginPerformedCorreclty(){
        return mainPage.isDisplayed();
    }

}
