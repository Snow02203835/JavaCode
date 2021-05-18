package Homework.factory.phone;

public class Apple implements Factory {
    @Override
    public Product create(String series) {
        return new Pad("苹果", series);
    }
}
