package by.issoft.internet;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class Frames {

    SelenideElement iFrameOptionLink = $("a[href='/iframe']");
    SelenideElement defaultTextBody = $("html");
    SelenideElement numberedList = $(".mce-i-numlist");

    public String getTextBody(){
        iFrameOptionLink.click();
        numberedList.click();

        return defaultTextBody.getText();
    }

}
