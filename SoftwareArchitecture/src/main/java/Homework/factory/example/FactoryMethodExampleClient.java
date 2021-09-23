package Homework.factory.example;

public class FactoryMethodExampleClient {
    public static void main(String[] args) {
        Factory factory = new ConcreteFactory();
        Product product = factory.newProduct();
        product.show();
    }
}
