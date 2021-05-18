package Homework.factory.phone;

public class Main {
    public static void main(String[] args) {
        Factory factory = new Mi();
        System.out.println(factory.create("Mix4").showInformation());
        System.out.println(factory.create("11Ultra").showInformation());
        factory = new Apple();
        System.out.println(factory.create("iPad Air").showInformation());
        System.out.println(factory.create("iPad Pro").showInformation());
        factory = new Huawei();
        System.out.println(factory.create("P40 Pro+").showInformation());
        System.out.println(factory.create("Mate 40").showInformation());
    }
}
