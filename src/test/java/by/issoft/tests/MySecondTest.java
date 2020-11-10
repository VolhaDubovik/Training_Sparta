package by.issoft.tests;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.sun.org.glassfish.gmbal.Description;
import io.qameta.allure.Attachment;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
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

    @DataProvider
    public Object[][] edostavka() {
        Object[][] data = new Object[1][3];

     // для метода "findCoffeePrice"
        data[0][0] = "Кофе молотый «Dallmayr» classic, 250 г.";
        data[0][2] = 13.58;

     // Случай, когда у нас значение в матрице из xpath "findCoffeePriceViaXpath"
        data[0][0] = "Кукват";
        data[0][1] = "//div[@class='tit63426le']/a[contains(text(),'" + data[0][0] + "')]/../following-sibling::div[@class='price456375s__wrapper']//div[@class='price']";
        data[0][2] = 13.58;

        return data;
    }


    @Test(dataProvider = "edostavka")

    public void findCoffeePrice(String searchText, double expectedPrice) {

        open("https://e-dostavka.by/");

        String searchLocator = "//div[@class='main_menu__inner']//i[@class='fa fa-search']";
        SelenideElement searchButton = $x(searchLocator);
        searchButton.click();
        $x("//input[@id='searchtext']").setValue(searchText).pressEnter();


        /*для быстрого дебагинга, что у нас все хорошо проходит с конкретного место, можно так поступать, если выше ничего значимого не происходит
        open("https://e-dostavka.by/search/?searchtext=%D0%9A%D0%BE%D1%84%D0%B5+%D0%BC%D0%BE%D0%BB%D0%BE%D1%82%D1%8B%D0%B9+%C2%ABDallmayr%C2%BB+classic%2C+250+%D0%B3.");
*/
        //Option 1 - Цена товара
        String actualPrice = $x("//div[@class='title']/a[contains(text(),'" + searchText + "')]/../following-sibling::div[@class='prices__wrapper']//div[@class='price']").getText();
        actualPrice = actualPrice.replace("р.", ".").replace("к.", ""); //из строки делаем число
        double actPrice = Double.parseDouble(actualPrice);
        Assert.assertEquals(expectedPrice, actPrice, "Goods price is different!");


//      Как работать с Cookie - F12 -> Application -> Storage - Cookies - смотрим нам нужные значения, которые хотим использовать
/*        open("https://github.com/artemmoroz/sparta2/blob/master/src/test/java/com/group2/tests/MySecondTest.java");
        Cookie ck = new Cookie("dotcom_user", "VolhaDubovik");
        WebDriverRunner.getWebDriver().manage().addCookie(ck);
        Cookie ck2 = new Cookie("_gh_sess", "41RCS9doBPQ0wfujen5QSDSFi1hnLN7Yo7SeKen9Llby6UolrO8TXH3BTOhM%2F09NgL6IlFux86uUGADS7%2BpU67X56iwdZSelLHCS1yCSKBkzxesqyWYOll21Tqtazbhlrb8Xr7T8Wa7GMC%2BUX0bVlwUXE1Za5S0R3Ro5mmCDzHfGk9OYwhw7NLVC0TDQnoqDKKv9ioFNbzs8n%2F%2B%2BA7tdjorfTDcgyS5GYS6dLuGWt79RxsxkhqkvilighqB3kun5opT3yGuycf67qSa9rXga052vR3rZIP2IILPZZ9pbxSJPGyAJxwsPhVn5wb9d5%2Fnp526zBoMZFc%2BuvW3iNvNMq%2FOa%2FKE9HyArTQNiF7sl1G%2BScIANDBp72Pa%2Buhxk5ae%2BorxUzuCrqq06D8J0S3TEV5B6o7EyIutkstz3JgxleOV4Y6cn%2BYvyEKmorr8ydtluJa3GOOu324dWC8YE%2FRO76XJhYEb%2FcpgKPNuMNxUXZxU2Qrq16h8ylEPutPFHkNs%2FtQsS1Z5ZYbGE29gVV84ISQZZ%2BrAa2f0zy%2BJJRI99WSaBDfzKdCc5jeNVrGsex8w7dVdJ%2B3L4mnuKA0FJZYQcmMKncCpWjs7Pssuhz%2FMd7nV%2Bi%2FAhUztOqtJ2QgZu2Nr9yyw0n%2BIShYmmaGKXccdHQb45n9cI5qInX88ZTnSHDAr1%2FS%2BXr5SGzguFMS%2Fr3J5x%2Bau8kEzI4ojOCZpBv8ld1R%2BloeCcOr1C%2BpUZWcSYum2z28HzF%2BlJYQOAxyKHKzCnlQCkwm64V1ezQhzby2LTIyd1lINZRGsWdnDnBl63K5xvYt919hy4%2BLbIulmFTX%2Ffw9FUREqkAzCTKCYjYY7Ljg5nJBY482p8eAqDMXojp62iQQPmEq2VqDbqPxMJMlzlX3yAV6wTVyk284pmrqd%2BzHT2JZuO%2FleCOVrn5pbT%2BwXutpltcaPQST%2FNqqAVFkkS%2FiHOvJuirOlcqnto%2BqMoNWP9njXd4wpo8NdgNBLpI5dyDATXzqcYWhh8G%2B5XjNxjDK6joV0vSXk%2BqOMR9e2aNE22FHfhEEkePAcfVPGqq%2Ba39yvEG%2Fn3oOIpTM%2BcD3SgDKXw1twF%2Br8%3D--3dIiB%2BOZx7QhO89N--iydQGheyEWCbOB3Qg55eig%3D%3D");
        WebDriverRunner.getWebDriver().manage().addCookie(ck2);
        Cookie ck3 = new Cookie("user_session", "LS0G-U0bDTDGdlDa3Zc_ZbUHK7dUcnrVKQxIaBtJ3Mm67nu4");
        WebDriverRunner.getWebDriver().manage().addCookie(ck3);
        open("https://github.com/artemmoroz/sparta2/blob/master/src/test/java/com/group2/tests/MySecondTest.java");*/

    }

    @Test(dataProvider = "edostavka")
    @Severity(SeverityLevel.CRITICAL)
    @Description("dsgsdgsg")
    @TmsLink("JIRA-352")
    @Attachment

    public void findCoffeePriceViaXpath(String searchText, String priceXpath, double expectedPrice) {

        open("https://e-dostavka.by/");

        String searchLocator = "//div[@class='main_menu__inner']//i[@class='fa fa-search']";
        SelenideElement searchButton = $x(searchLocator);
        searchButton.click();
        $x("//input[@id='searchtext']").setValue(searchText).pressEnter();


        //Option 1 - Цена товара через Xpath
        String actualPrice = $x(priceXpath).getText();
        actualPrice = actualPrice.replace("р.", ".").replace("к.", ""); //из строки делаем число
        double actPrice = Double.parseDouble(actualPrice);
        Assert.assertEquals(expectedPrice, actPrice, "Goods price is different!");

        // не знаю для чего это, на видео не попало
        SelenideElement a = $x("//div[@class='title']/a[contains(text(),'"+searchText+"')]");
        a.click();

    }




}






