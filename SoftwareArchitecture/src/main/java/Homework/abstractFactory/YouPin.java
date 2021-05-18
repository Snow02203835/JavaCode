package Homework.abstractFactory;

public class YouPin extends Factory {
    public YouPin(){
        super("小米有品");
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
