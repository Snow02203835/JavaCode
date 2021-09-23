package Homework.prototype.example;

public class PrototypeExampleClient {
    public static void main(String[] args) {
        Prototype prototype1 = new RealizeType("world");
        Prototype prototype2 = prototype1.clone();
        System.out.println(prototype1 == prototype2);
    }
}
