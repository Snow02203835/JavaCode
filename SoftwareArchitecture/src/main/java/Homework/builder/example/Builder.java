package Homework.builder.example;

public abstract class Builder {
    protected Product product;
    public abstract void buildPartA();
    public abstract void buildPartB();
    public abstract void buildPartC();
    public Product getFinalProduct(){
        return product;
    }
}
