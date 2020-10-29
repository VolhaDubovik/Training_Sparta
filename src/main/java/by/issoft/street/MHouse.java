package by.issoft.street;

public class MHouse extends House{

    public MHouse(int houseNumber) {
        super(houseNumber);
    }

    public double calculatePrice() {
        double price = 0;
        for (Flat flat : flats){
            price = price + flat.calculatePrice();
        }
        return price;
    }
}
