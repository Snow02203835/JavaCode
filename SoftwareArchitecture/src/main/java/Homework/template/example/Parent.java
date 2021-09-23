package Homework.template.example;

public abstract class Parent {
    public void templateMethod(Integer num){
        specificMethod();
        abstractMethod1();
        abstractMethod2();
        if (isDone(num)) {
            specificMethod();
        }
    }
    protected boolean isDone(Integer num){
        return true;
    }
    private void specificMethod(){
        System.out.println("Common code in Child Class");
    }
    public abstract void abstractMethod1();
    public abstract void abstractMethod2();
}
