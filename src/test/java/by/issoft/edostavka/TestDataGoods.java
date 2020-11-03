package by.issoft.edostavka;

import org.testng.annotations.DataProvider;

import static com.codeborne.selenide.Selenide.$x;

public class TestDataGoods {

    @DataProvider
    public Object[][] dataForCheckGoodsPrice(){
        Object[][] data = new Object[5][4];

        data[0][0] = "Кофе молотый «Dallmayr» classic, 250 г.";
        data[0][1] = "Кофе молотый «Dallmayr» classic, 250 г.";
        data[0][2] = "54.2";
        data[0][3] = "54.2";

        data[1][0] = "Конфеты Коммунарка «Любимая Аленка» 200 г.";
        data[1][1] = "Конфеты Коммунарка «Любимая Аленка» 200 г.";
        data[1][2] = "15.95";
        data[1][3] = "8.38";

        data[2][0] = "Мука пшеничная «Makfa» хлебопекарная, 2 кг.";
        data[2][1] = "Мука пшеничная «Makfa» хлебопекарная, 2 кг.";
        data[2][2] = "1.73";
        data[2][3] = "82.42";

        data[3][0] = "Клюква «Эко Хуторок» лесная, 180 г.";
        data[3][1] = "Клюква «Эко Хуторок» лесная, 180 г.";
        data[3][2] = "24.94";
        data[3][3] = "15.95";

        data[4][0] = "Салями «Ungherese» сыровяленое, нарезка, 80 г.";
        data[4][1] = "Салями «Ungherese» сыровяленое, нарезка, 80 г.";
        data[4][2] = "58.42";
        data[4][3] = "58.42";

        return data;

    }
}
