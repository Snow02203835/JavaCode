package Homework.iterator.example;

public class ConcreteAggregate extends Aggregate {
    @Override
    public Iterator iterator() {
        return new ConcreteIterator(this);
    }
}
