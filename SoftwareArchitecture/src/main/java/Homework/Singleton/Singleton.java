package Homework.Singleton;

public class Singleton {
    private static Singleton singleton;
    private static final Integer i = 0;
    private Singleton(){

    }

    public static Singleton getInstance(){
        if (singleton == null){
            synchronized(i){
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
