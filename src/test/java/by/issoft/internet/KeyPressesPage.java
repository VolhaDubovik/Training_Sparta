package by.issoft.internet;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class KeyPressesPage {

    SelenideElement inputField = $("#target");
    SelenideElement resultLine = $("#result");

    public boolean isEnteredValueDisplayedInResultLine(String value){

        inputField.setValue(value);
        return resultLine.getText().contains(value);
    }

    public String inputKeyPressTab(){
        inputField.pressTab();
        return resultLine.getOwnText();
    }


}
