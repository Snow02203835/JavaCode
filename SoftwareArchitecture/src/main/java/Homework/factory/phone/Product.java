package Homework.factory.phone;

public abstract class Product {
    protected String brand;
    protected String series;

    public abstract String showInformation();
    public Product(String brand, String series){
        this.brand = brand;
        this.series = series;
    }
}
