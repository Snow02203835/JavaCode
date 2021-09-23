package Homework.iterator.example;

import java.util.ArrayList;
import java.util.List;

public abstract class Aggregate {
    private final List<Item> items = new ArrayList<>();
    public abstract Iterator iterator();
    public Item getItems(int index){
        return items.get(index);
    }
    public void addItem(Item item){
        items.add(item);
    }
    public int getSize(){
        return items.size();
    }
}
