package Homework.observer;

import java.util.Observable;
import java.util.Observer;

public class DigitObserver implements Observer {
    @Override
    public void update(Observable generator, Object arg) {
        System.out.println("DigitObserver: " + arg);
    }
}
