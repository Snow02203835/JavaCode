package Homework.abstractFactory;

public class Mitsubishi extends Factory {
    public Mitsubishi() {
        super("三菱");
    }

    @Override
    public Product createTV(String series) {
        return new TV(this.name, series);
    }

    @Override
    public Product createFridge(String series) {
        return new Fridge(this.name, series);
    }

    @Override
    public Product createAirCondition(String series) {
        return new AirCondition(this.name, series);
    }
}
