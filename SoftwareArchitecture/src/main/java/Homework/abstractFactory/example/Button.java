package Homework.abstractFactory.example;

public abstract class Button {
    protected String name;

    public void setName(String name) {
        this.name = name;
    }

    public abstract String click();
}
