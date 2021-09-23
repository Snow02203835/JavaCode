package Homework.factory.example;

public class ConcreteFactory implements Factory {
    @Override
    public Product newProduct() {
        return new ConcreteProduct();
    }
}
