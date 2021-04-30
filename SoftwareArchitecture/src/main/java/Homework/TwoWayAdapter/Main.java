package Homework.TwoWayAdapter;

public class Main {
    public static void main(String[] args) {
        Dog dog = new CDog();
        Parrot parrot = new TwoWayAdapter(dog);
        parrot.fly();
        parrot = new CParrot();
        dog = new TwoWayAdapter(parrot);
        dog.bark();
    }
}
