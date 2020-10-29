package by.issoft.street;

import java.util.ArrayList;
import java.util.List;

public class Street implements PriceCalculator {

    String name;
    List<PriceCalculator> priceCalculators; // после того, как создали interface PriceCalculator -
    //Flat.AutoWasher autoWasher;


    public Street(String name) {
        this.name = name;
        this.priceCalculators = new ArrayList<>(); // после того, как создали interface PriceCalculator
    }

    public void addBuilding(PriceCalculator priceCalculator){

        priceCalculators.add(priceCalculator);
    }

    public void addBuildings(List<PriceCalculator> cc){
        this.priceCalculators = cc; //сделать групповой метод приема домов
    }


    public double calculatePrice() {
        double price = 0;
        for (PriceCalculator priceCalculator : priceCalculators){
            price = price + priceCalculator.calculatePrice();
        }
        return price;
    }

}
