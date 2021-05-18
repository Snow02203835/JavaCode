package Homework.abstractFactory;

public abstract class Product {
    protected String brand;
    protected String series;

    public abstract String showInformation();
    public Product(String factoryName, String series){
        this.brand = factoryName;
        this.series = series;
    }
}
