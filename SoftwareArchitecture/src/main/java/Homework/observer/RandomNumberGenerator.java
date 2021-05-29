package Homework.observer;

import java.util.Random;

public class RandomNumberGenerator extends NumberGenerator {
    private final Random random = new Random();

    @Override
    public void execute() {
        number = random.nextInt(50);
        notifyObservers();
    }
}
