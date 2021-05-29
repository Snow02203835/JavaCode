package Homework.observer;

import java.util.Observable;
import java.util.Observer;

public class GraphObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        Integer num = (Integer)arg;
        System.out.print("GraphObserver: ");
        for (int i = 0; i < num; i++){
            System.out.print('*');
        }
        System.out.println("");
    }
}
