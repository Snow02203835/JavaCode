package Homework.abstractFactory;

public class GeLi extends Factory {
    public GeLi() {
        super("格力");
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
