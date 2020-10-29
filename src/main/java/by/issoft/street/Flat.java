package by.issoft.street;

public class Flat implements PriceCalculator {

    int flatNumber;
    int square;
    int people;

    public Flat(int flatNumber, int square, int people) {
        this.flatNumber = flatNumber;
        this.square = square;
        this.people = people;
    }

    public double calculatePrice() {

        return square * people;
    }



}
