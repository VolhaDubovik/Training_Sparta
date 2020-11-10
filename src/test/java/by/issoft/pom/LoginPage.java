package by.issoft.pom;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Selenide.$;

@Data
@Accessors(chain = true)
@Slf4j

public class LoginPage {
    SelenideElement login = $("login");
    SelenideElement pass = $("pass");
    SelenideElement submit = $("submit");
    SelenideElement logoutButton = $("logout");

    HeaderComponent headerComponent = new HeaderComponent();

    public LoginPage() {

    }
//    public LoginPage(String url) {
//    pen(url);
//    }

    public MainPage login(String u, String p){
        login.setValue(u);
        pass.setValue(p);
        //log.debug("34");
        submit.click();
        //assert ok
        return new MainPage();
    }

    public boolean isLoginPerformdCorreclty(){
        return  login.isDisplayed();
    }


    public void logout(){
        //profile.click();
        headerComponent.profile.click();
        logoutButton.click();
    }

}
