package Homework.abstractFactory;

public class TV extends Product{
    public TV(String factory, String series){
        super(factory, series);
    }
    @Override
    public String showInformation() {
        return brand + "电视" + series;
    }
}
