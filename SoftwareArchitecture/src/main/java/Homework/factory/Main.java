package Homework.factory;

import Homework.factory.card.CreditCardFactory;
import Homework.factory.card.IDCardFactory;
import Homework.factory.framework.Factory;
import Homework.factory.framework.Product;

public class Main {
    public static void main(String[] args) {
        Factory factory1 = new IDCardFactory();
        Factory factory2 = new CreditCardFactory();
        createProduct(factory1);
        createProduct(factory2);
    }
    private static void createProduct(Factory factory){
        Product product = factory.create("墙外行人");
        product.use();
    }
}
