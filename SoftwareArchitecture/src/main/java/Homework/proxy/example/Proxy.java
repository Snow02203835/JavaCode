package Homework.proxy.example;

public class Proxy implements Subject {
    private final Subject subject;

    public Proxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        preRequest();
        subject.request();
        postRequest();
    }

    private void preRequest(){
        System.out.println("Before Real Subject called!");
    }

    private void postRequest(){
        System.out.println("After Real Subject called!");
    }
}
