package by.issoft.internet;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class FramesPage {

    SelenideElement iFrameOptionLink = $("a[href='/iframe']");
    SelenideElement OkPopUpButton = $x("//button[.='Ok']");
    SelenideElement numberedListButton = $x("//i[@class='mce-ico mce-i-numlist']");
    SelenideElement frameBodyPart = $("#mce_0_ifr");

    public String getDefaultTextBodyAfterNumbered(){
        iFrameOptionLink.click();
        numberedListButton.click();
        return frameBodyPart.getText();
    }

    public void setFrameBodyText(String text){
        iFrameOptionLink.click();
        OkPopUpButton.click();
        frameBodyPart.waitUntil(Condition.appear, 4000);
        switchTo().frame(frameBodyPart);
        frameBodyPart.clear();
        frameBodyPart.setValue(text);

    }

    public String getFrameBodyText(){
        setFrameBodyText("Hello");
        return frameBodyPart.getText();
    }

}
