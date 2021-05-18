package Homework.factory.phone;

public class Pad extends Product {
    public Pad(String brand, String series) {
        super(brand, series);
    }

    @Override
    public String showInformation() {
        return brand + "平板" + series;
    }
}
