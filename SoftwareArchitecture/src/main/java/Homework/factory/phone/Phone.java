package Homework.factory.phone;

public class Phone extends Product {
    public Phone(String factoryName, String series) {
        super(factoryName, series);
    }

    @Override
    public String showInformation() {
        return brand + "手机" + series;
    }
}
