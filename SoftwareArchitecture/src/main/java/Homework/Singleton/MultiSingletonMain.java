package Homework.Singleton;

public class MultiSingletonMain {
    public static void main(String[] args) {
        int num = 10;
        MultiSingleton[] multiSingleton;
        multiSingleton = MultiSingleton.getInstance(num);
        if(multiSingleton != null) {
            for(int i = 0; i < num; i++){
                for (int j = i+1; j < num; j++){
                    if(multiSingleton[i] == multiSingleton[j]){
                        System.out.println("Same Instance! " + i + " - " + j);
                    }
                    else{
                        System.out.println("Different Instance! " + i + " - " + j);
                    }
                }
            }
        }
        else{
            System.out.println("Request too much singleton!");
        }
    }
}
