package Homework.iterator.specified;

import Homework.iterator.Iterator;

public class AIterator implements Iterator {
    private int index;
    private final Aggregate aggregate;
    public AIterator(Aggregate aggregate){
        index = 0;
        this.aggregate = aggregate;
    }

    @Override
    public Object end() {
        index = aggregate.getLength()-1;
        return aggregate.getIntroduction(aggregate.getLength()-1);
    }

    @Override
    public Object next() {
        if(hasNext()){
            return aggregate.getIntroduction(index++);
        }
        return null;
    }

    @Override
    public Object last() {
        if(hasLast()){
            return aggregate.getIntroduction(--index);
        }
        return null;
    }

    @Override
    public Object begin() {
        index = 0;
        return aggregate.getIntroduction(0);
    }

    @Override
    public boolean hasNext() {
        return index < aggregate.getLength();
    }

    @Override
    public boolean hasLast() {
        return index > 0;
    }
}
