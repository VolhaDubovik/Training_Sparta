package by.issoft.internet;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class DropdownPage {

    SelenideElement dropdownField = $("#dropdown");
    SelenideElement dropdownOption1 = $x("//option[.='Option 1']");

    public String getSelectedDropdownOption() {

        dropdownField.click();
        dropdownOption1.click();
        String selectedDropdownOption = dropdownField.getText();
        return selectedDropdownOption;
    }

}
