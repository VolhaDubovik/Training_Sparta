package by.issoft.street;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.collections4.CollectionUtils;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class MainClass {

    public static void main(String[] args) throws IOException {
        Street street = new Street("Lenina"); //улице мы хотим дать название


        //multiFlat house

        List<Flat> manyFlatHouseFlatList = Arrays.asList( //3 - добавили список квартиры в дом - у нас будет лист квартир = и это будет список квартир для многоквартирного дома, так как мы с кв ничего делать не будем, то мы можем сделать неизменяемый список, потому что нам нужно только собирать дань с квартир => поэтому мы можем написать сразу Arrays.asList() - не обязательно делать new ArrayList<>(Arrays.asList());

                new Flat(1, 30, 1),
                new Flat(2, 50, 2),
                new Flat(3, 70, 4)  //4 - создали набор квартир

        );

        House manyFlatHouse = new MHouse(1); //1 - объявили новый экземпляр класса - (1) - это номер дома
        manyFlatHouse.addFlats(manyFlatHouseFlatList);//5 - нужно сказать, что созданные квартиры принадлежат нашему дому House(1)
        street.addBuilding(manyFlatHouse); //2 - добавили дома на нашу улицу

        /*       street.addHouse(new House(1).addFlats( //в дом мы хотим добавить квартиры
                Arrays.asList(
                        new Flat(50, 3),
                        )
        ));//в улицу мы хотим добавить дома*/

        //townHouse

        List<Flat> townHouseFlatList = Arrays.asList( //3 - добавили список квартиры в дом - у нас будет лист квартир = и это будет список квартир для многоквартирного дома, так как мы с кв ничего делать не будем, то мы можем сделать неизменяемый список, потому что нам нужно только собирать дань с квартир => поэтому мы можем написать сразу Arrays.asList() - не обязательно делать new ArrayList<>(Arrays.asList());

                new Flat(1, 130, 3),
                new Flat(2, 150, 2)

        );

        House townHouse = new TownHouse(2); //мы здесь используем House, а не PriceCalculator - потому что PC может только считать деньги, а в House у нас написаны все остальные методы
        townHouse.addFlats(townHouseFlatList);
        street.addBuilding(townHouse);

        //cottage
        List<Flat> cottageFlatList = Arrays.asList( //3 - добавили список квартиры в дом - у нас будет лист квартир = и это будет список квартир для многоквартирного дома, так как мы с кв ничего делать не будем, то мы можем сделать неизменяемый список, потому что нам нужно только собирать дань с квартир => поэтому мы можем написать сразу Arrays.asList() - не обязательно делать new ArrayList<>(Arrays.asList());

                new Flat(1, 330, 2)

        );

        House cottage = new Cottage(3);
        cottage.addFlats(cottageFlatList);
        street.addBuilding(cottage);

        //-------------------------------------------------

        street.addBuilding(new Washer());

        street.addBuilding(new ShavaStore());


        System.out.println("Total street money: " + street.calculatePrice());

        //---------------------------------------------------

        String json = given().get("https://www.nbrb.by/api/exrates/rates?periodicity=0").asString();

        ObjectMapper mapper = new ObjectMapper();
        BankData[] bankData = mapper.readValue(json, BankData[].class);
        //    List<BankData> bankDataList = mapper.readValue(json, new TypeReference<List<BankData>>() {});

        List<BankData> bankDataList = new ArrayList<>(); // объявляю новый список
        CollectionUtils.addAll(bankDataList, bankData); // преобразовать массив в лист и заполняю свой новый лист данными из массива


        System.out.println(bankData.length);


        double streetPriceBYN = street.calculatePrice();
        String abbreviation = "USD";

        for (BankData element : bankDataList) {
            if (abbreviation.equals(element.getAbbreviation())) {
                double valute = element.exchangeBYN(streetPriceBYN);
                DecimalFormat value = new DecimalFormat(("##.00")); // чтобы округляло до десятичных
                System.out.println(element.getCurrencyName() + " : " + value.format(valute)); // value.format(valute) - чтобы округляло до десятичных

            }

        }

    }
}
