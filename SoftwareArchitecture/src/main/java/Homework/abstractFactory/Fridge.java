package Homework.abstractFactory;

public class Fridge extends Product {
    public Fridge(String factoryName, String series) {
        super(factoryName, series);
    }
    @Override
    public String showInformation() {
        return brand + "冰箱" + series;
    }
}
