package by.issoft.edostavka;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class FindGoods {

    @BeforeTest
    public void sayHello() {
        System.out.println("Start Test CheckGoodsPrice");
    }

    @Test(dataProvider = "dataForCheckGoodsPrice", dataProviderClass = TestDataGoods.class)
    public void findCoffeePrice(String inputText, String selectedItem, String actualPrice, String expectedPrice) {
        Configuration.timeout = 30000;

        open("https://e-dostavka.by/");

        String searchLocator = "//div[@class='main_menu__inner']//i[@class='fa fa-search']";
        $x(searchLocator).click();

        $x("//input[@id='searchtext']").setValue(inputText);

        $x(searchLocator).click();

        $x("//img[@alt='" + selectedItem + "']").click();

        //String actPrice = $x("//span[contains(text(),'" + actualPrice + "')]").getText();


        Assert.assertEquals(expectedPrice, actualPrice, "Goods price is different!");

    }
}
