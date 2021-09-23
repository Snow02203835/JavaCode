package Homework.adapter.twoWayAdapter;

public class TwoWayAdapter implements Dog, Parrot {
    private Dog dog;
    private Parrot parrot;

    public TwoWayAdapter(Dog dog) {
        this.dog = dog;
    }

    public TwoWayAdapter(Parrot parrot) {
        this.parrot = parrot;
    }

    @Override
    public void bark() {
        parrot.fly();
    }

    @Override
    public void fly() {
        dog.bark();
    }
}
