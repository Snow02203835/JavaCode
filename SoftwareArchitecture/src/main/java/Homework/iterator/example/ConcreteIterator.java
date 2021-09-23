package Homework.iterator.example;

public class ConcreteIterator extends Iterator {

    public ConcreteIterator(Aggregate aggregate) {
        super(aggregate);
    }

    @Override
    public boolean hasNext() {
        return index < aggregate.getSize();
    }

    @Override
    public boolean hasLast() {
        return index > 0;
    }

    @Override
    public Item next() {
        if (hasNext()) {
            return aggregate.getItems(index++);
        }
        return null;
    }

    @Override
    public Item last() {
        if (hasLast()) {
            return aggregate.getItems(--index);
        }
        return null;
    }
}
