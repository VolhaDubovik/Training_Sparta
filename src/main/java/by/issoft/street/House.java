package by.issoft.street;

import java.util.List;

public abstract class House implements PriceCalculator {

    int houseNumber; // номер дома
    List<Flat> flats; // у дома есть св-во  -

    public House(int houseNumber) {

        this.houseNumber = houseNumber;

    }

    public void addFlats(List<Flat> flats) {
        this.flats = flats; // мы говорим, что наши белые квартиры извне (которые мы создали в main) будут в нашем доме, и через конструктор мы это говорим
    }

    public abstract double calculatePrice();

}
