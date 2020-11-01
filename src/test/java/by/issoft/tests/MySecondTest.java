package by.issoft.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MySecondTest {

    @Test
    public void userCanLoginByUsername() {
        open("https://ya.ru/");// открываем нужную страницу

        $(By.cssSelector("#text")).setValue("Hello Sparta"); //если нужно ввести текстовое значение в серч поле

        $(By.xpath("//tbody/tr[2]/td[1]/form[1]/div[2]/button[1]")).click(); // если мы хотим кликнуть на кнопку

        //$x("//tbody/tr[2]/td[1]/form[1]/div[2]/button[1]");

        $$("li.serp-item").forEach(item -> System.out.println(item.getText()));

        String countResults = $(".serp-adv__found").getText();//хотим узнать его текст, можно делать через Assert

        System.out.println(countResults);

        System.out.println(22);

/*        $(By.name("user.name")).setValue("johny");
        $("#submit").click();
        $(".loading_progress").should(disappear); // Waits until element disappears
        $("#username").shouldHave(text("Hello, Johny!")); // Waits until element gets text*/
    }

}
