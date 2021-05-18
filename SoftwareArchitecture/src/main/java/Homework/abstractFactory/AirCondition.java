package Homework.abstractFactory;

public class AirCondition extends Product {
    public AirCondition(String factory, String series){
        super(factory, series);
    }
    @Override
    public String showInformation() {
        return brand + "空调" + series;
    }
}
