package Homework.iterator.specified;

import Homework.iterator.Iterator;

public class Main {
    public static void main(String[] args) {
        Aggregate aggregate = new Aggregate();
        aggregate.addIntroduction("紫霞", "head006.jpg");
        aggregate.addIntroduction("冰冰", "head007.jpg");
        aggregate.addIntroduction("星仔", "head008.jpg");
        aggregate.addIntroduction("快银", "head010.png");
        aggregate.addIntroduction("超越", "head011.png");
        aggregate.addIntroduction("朱茵", "head015.jpg");
        Iterator iterator = aggregate.iterator();
        while(iterator.hasNext()){
            Introduction introduction = (Introduction)iterator.next();
            System.out.println(introduction.getPicture() + " " + introduction.getText());
        }
        Window window = new Window(aggregate);
    }
}
