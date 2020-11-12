package by.issoft.email;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AvatarPopUp {

    SelenideElement avatarIcon = $x("//a[@href='https://passport.yandex.by']//img[@src='https://avatars.mds.yandex.net/get-yapic/0/0-0/islands-middle']");
    SelenideElement logoutButton = $x("//span[.='Log out']");

    public void logout(){
        avatarIcon.click();
        logoutButton.click();
    }

}
