package Homework.iterator.example;

public abstract class Iterator {
    protected int index;
    protected final Aggregate aggregate;
    public Iterator(Aggregate aggregate){
        this.index = 0;
        this.aggregate = aggregate;
    }
    public abstract boolean hasNext();
    public abstract boolean hasLast();
    public abstract Item next();
    public abstract Item last();
}
