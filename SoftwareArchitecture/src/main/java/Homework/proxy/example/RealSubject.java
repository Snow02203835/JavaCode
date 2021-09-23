package Homework.proxy.example;

public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("Real Subject called!");
    }
}
