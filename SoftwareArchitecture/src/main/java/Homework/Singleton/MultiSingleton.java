package Homework.Singleton;

public class MultiSingleton {
    private static Integer currentInstanceNumber = 0;
    private static final Integer maxInstanceNumber = 100;
    private static MultiSingleton[] singleton;
    private MultiSingleton(){

    }

    public static MultiSingleton[] getInstance(int num){
        if (singleton == null){
            singleton = new MultiSingleton[maxInstanceNumber];
        }
        if(num > maxInstanceNumber){
            return null;
        }
        if(num > currentInstanceNumber){
            for (int i = currentInstanceNumber; i < num; i++) {
                singleton[i] = new MultiSingleton();
            }
            currentInstanceNumber = num;
        }
        MultiSingleton[] temp = new MultiSingleton[num];
        for(int i = 0; i < num; i++){
            temp[i] = singleton[i];
        }
        return temp;
    }
}
