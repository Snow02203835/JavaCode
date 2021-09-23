package Homework.iterator.example;

public class IteratorClient {
    public static void main(String[] args) {
        Aggregate aggregate = new ConcreteAggregate();
        aggregate.addItem(new Book("123"));
        aggregate.addItem(new Book("456"));
        aggregate.addItem(new Book("789"));
        Iterator iterator = aggregate.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().getName());
        }
        System.out.println("---------------------------");
        while (iterator.hasLast()){
            System.out.println(iterator.last().getName());
        }
    }
}
