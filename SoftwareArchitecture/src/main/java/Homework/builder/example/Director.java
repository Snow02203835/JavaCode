package Homework.builder.example;

public class Director {
    private Builder builder;
    public Product construct(){
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getFinalProduct();
    }
}
