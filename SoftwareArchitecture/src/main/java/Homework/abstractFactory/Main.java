package Homework.abstractFactory;

public class Main {
    public static void main(String[] args) {
        Factory factory = new YouPin();
        System.out.println(factory.createTV("1").showInformation());
        System.out.println(factory.createFridge("2").showInformation());
        System.out.println(factory.createAirCondition("2s").showInformation());
        factory = new GeLi();
        System.out.println(factory.createTV("3").showInformation());
        System.out.println(factory.createFridge("4").showInformation());
        System.out.println(factory.createAirCondition("3s").showInformation());
        factory = new Mitsubishi();
        System.out.println(factory.createTV("8").showInformation());
        System.out.println(factory.createFridge("9").showInformation());
        System.out.println(factory.createAirCondition("8s").showInformation());
    }
}
