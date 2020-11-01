package by.issoft.edostavka;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class FindCoffee {

    @Test
    public void findCoffeeViaSearchBox() {
        Configuration.timeout = 30000;
        open("https://e-dostavka.by/");
        $x("//body/div[@id='body']/div[1]/div[3]/div[2]/div[1]/nav[1]/ul[1]/li[9]/a[1]/i[1]").click();
        $x("//input[@id='searchtext']").setValue("Кофе молотый «Dallmayr» classic, 250 г.");
        $x("//body/div[@id='body']/div[1]/div[3]/div[2]/div[1]/nav[1]/ul[1]/li[9]/a[1]/i[1]").click();
        $x("//body/div[@id='body']/div[1]/div[3]/div[3]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]").click();

        String price = $x("//span[contains(text(),'54.2')]").getText();

        $x("//span[contains(text(),'54.2')]").shouldHave(text("54.2"));

        //?? условие, если shouldHave совпадает, то печатаем, иначе ошибку выводить

        System.out.println("Price per kg: " + price);

    }

    @Test
    public void findCoffeeViaDropDownCoffeeName(){
        Configuration.timeout = 30000;
        open("https://e-dostavka.by/");
        $x("//body/div[@id='body']/div[1]/div[3]/div[2]/div[1]/nav[1]/ul[1]/li[9]/a[1]/i[1]").click();
        $x("//input[@id='searchtext']").setValue("Кофе молотый «Dallmayr» classic, 250 г.");
        $x("//a[contains(text(),'Кофе молотый «Dallmayr» classic, 250 г.')]").click();
        $x("//body/div[@id='body']/noindex[2]/div[1]/div[1]/div[1]/div[1]").waitUntil(appears, 10000);

        String price = $x("//span[contains(text(),'54.2')]").getText();

        System.out.println("Price per kg: " + price);
    }

    @Test
    public void findCoffeeViaDropDownCoffeeImage(){
        Configuration.timeout = 30000;
        open("https://e-dostavka.by/");
        $x("//body/div[@id='body']/div[1]/div[3]/div[2]/div[1]/nav[1]/ul[1]/li[9]/a[1]/i[1]").click();
        $x("//input[@id='searchtext']").setValue("Кофе молотый «Dallmayr» classic, 250 г.");
        $x("////body/div[@id='body']/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/a[1]/img[1]").click();
        $x("//body/div[@id='body']/noindex[2]/div[1]/div[1]/div[1]/div[1]").waitUntil(appears, 10000);

        String price = $x("//span[contains(text(),'54.2')]").getText();

        System.out.println("Price per kg: " + price);
    }


}
