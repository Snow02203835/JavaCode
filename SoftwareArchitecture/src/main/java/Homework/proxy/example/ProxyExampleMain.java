package Homework.proxy.example;

public class ProxyExampleMain {
    public static void main(String[] args) {
        Subject proxy = new Proxy(new RealSubject());
        proxy.request();
    }
}
