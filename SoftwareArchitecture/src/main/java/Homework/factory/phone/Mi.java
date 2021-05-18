package Homework.factory.phone;

public class Mi implements Factory {
    @Override
    public Product create(String series) {
        return new Phone("小米", series);
    }
}
