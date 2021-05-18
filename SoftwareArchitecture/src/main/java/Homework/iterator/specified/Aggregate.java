package Homework.iterator.specified;

import Homework.iterator.Iterator;

import java.util.ArrayList;
import java.util.List;

public class Aggregate {
    private final List<Introduction> introductions;

    public Aggregate(){
        introductions = new ArrayList<>();
    }

    public int getLength(){
        return introductions.size();
    }

    public Introduction getIntroduction(int i){
        if (i >= 0 && i < introductions.size()){
            return introductions.get(i);
        }
        return null;
    }

    public void addIntroduction(String text, String imgURL){
        introductions.add(new Introduction(text, imgURL));
    }

    public Iterator iterator(){
        return new AIterator(this);
    }
}
