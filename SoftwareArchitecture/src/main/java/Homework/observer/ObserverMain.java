package Homework.observer;

import java.util.Observer;

public class ObserverMain {
    public static void main(String[] args) {
        NumberGenerator generator = new RandomNumberGenerator();
        Observer digitObserver = new DigitObserver();
        Observer graphObserver = new GraphObserver();
        generator.addObserver(digitObserver);
        generator.addObserver(graphObserver);
        for (int i = 0; i < 5; i++){
            generator.execute();
        }
    }
}
