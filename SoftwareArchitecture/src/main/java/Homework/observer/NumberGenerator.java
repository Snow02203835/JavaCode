package Homework.observer;

import java.util.*;

public abstract class NumberGenerator extends Observable {

    protected Integer number;
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers){
            observer.update(this, this.number);
        }
    }

    public abstract void execute();
}
