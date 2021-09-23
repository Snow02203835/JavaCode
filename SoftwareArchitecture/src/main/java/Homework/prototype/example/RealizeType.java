package Homework.prototype.example;

public class RealizeType implements Prototype {
    private final String name;
    public RealizeType(String name){
        this.name = name;
    }
    @Override
    public Prototype clone() {
        return new RealizeType(this.name);
    }
}
