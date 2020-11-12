package by.issoft.email;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appears;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginYandexPage {

    SelenideElement loginButton = $x("//div[contains(@class,'Footer')]//a[contains(@href,'auth?')]");
    SelenideElement loginField = $("#passp-field-login");
    SelenideElement submitButton = $(".Button2_view_action");
    SelenideElement passwordField = $("#passp-field-passwd");

    SelenideElement mainPage = $(".mail-Page");


    public void login(String loginValue, String passwordValue){
        loginButton.click();
        loginField.setValue(loginValue);
        submitButton.click();
        passwordField.waitUntil(appears, 40000);
        passwordField.setValue(passwordValue);
        submitButton.click();

    }

    public boolean isLoginPerformedCorreclty(){
        return mainPage.isDisplayed();
    }

}
