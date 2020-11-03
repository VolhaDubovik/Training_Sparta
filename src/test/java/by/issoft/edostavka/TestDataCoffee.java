package by.issoft.edostavka;

import org.testng.annotations.DataProvider;

import static com.codeborne.selenide.Selenide.$x;

public class TestDataCoffee {

    @DataProvider
    public Object[][] dataForCheckCoffeePrice(){

        return new Object[][]{{"54.2"},{"4.2"}};
    }
}
