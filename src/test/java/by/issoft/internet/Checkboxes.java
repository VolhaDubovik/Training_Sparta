package by.issoft.internet;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Checkboxes {

    ElementsCollection checkboxes = $$("#checkboxes");
    SelenideElement checkboxField1 = $("form#checkboxes > input:nth-of-type(1)");
    SelenideElement checkboxField2 = $("form#checkboxes > input:nth-of-type(2)");


}
