package Homework.abstractFactory;

public abstract class Factory {
    protected final String name;
    public Factory(String name){
        this.name = name;
    }
    public abstract Product createTV(String series);
    public abstract Product createFridge(String series);
    public abstract Product createAirCondition(String series);
}
