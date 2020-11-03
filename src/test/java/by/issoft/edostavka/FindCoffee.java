package by.issoft.edostavka;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class FindCoffee {

    @Test
    public void findCoffeeViaSearchBox() {
        Configuration.timeout = 30000;

        String priceExpected = "54.2";

        //open site
        open("https://e-dostavka.by/");
        String searchLocator = "//div[@class='main_menu__inner']//i[@class='fa fa-search']";
        //click on search button
        $x(searchLocator).click();

        String coffee = "Кофе молотый «Dallmayr» classic, 250 г.";
        // insert in search field
        $x("//input[@id='searchtext']").setValue(coffee);
        //click on search button
        $x(searchLocator).click();
        //select found item
        /*$x("//img[@alt='Кофе молотый «Dallmayr» classic, 250 г.']").click();*/
        //вариант как вставить строку в строку
        $x("//img[@alt='" + coffee + "']").click();

        //get item price
        String priceActual = $x("//span[contains(text(),'54.2')]").getText();

        $x("//span[contains(text(),'54.2')]").shouldHave(text(priceExpected));

        System.out.println("Price per kg: " + priceActual);
        //сравниваем Actual и Expected, выводим сообщение, если не совпадает
        Assert.assertEquals(priceActual, priceExpected, "Coffee price is different!");

    }

    @BeforeTest
    public void sayHello() {
        System.out.println("Start Test CheckCoffeePrice");
    }

    @Test(dataProvider = "dataForCheckCoffeePrice", dataProviderClass = TestDataCoffee.class)
    public void findCoffeePrice(String value) {
        Configuration.timeout = 30000;

        open("https://e-dostavka.by/");
        String searchLocator = "//div[@class='main_menu__inner']//i[@class='fa fa-search']";

        $x(searchLocator).click();

        String coffee = "Кофе молотый «Dallmayr» classic, 250 г.";

        $x("//input[@id='searchtext']").setValue(coffee);

        $x(searchLocator).click();
        //select found item

        $x("//img[@alt='" + coffee + "']").click();

        //get item price
        String priceActual = $x("//span[contains(text(),'54.2')]").getText();


        Assert.assertEquals(value, priceActual, "Coffee price is different!");

    }


}