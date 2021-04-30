package Homework.Singleton;

public class SingletonMain {
    public static void main(String[] args) {
        final Singleton[] singleton = new Singleton[2];
        Thread t1 = new Thread(() -> singleton[0] = Singleton.getInstance());
        Thread t2 = new Thread(() -> singleton[1] = Singleton.getInstance());
        t1.start();
        t2.start();
        if(singleton[0] == singleton[1]){
            System.out.println("Same Instance!");
        }
        else{
            System.out.println("Different Instance!");
        }
    }
}
