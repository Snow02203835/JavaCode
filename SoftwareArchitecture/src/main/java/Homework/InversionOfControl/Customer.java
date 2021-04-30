package Homework.InversionOfControl;

public class Customer {
    private final String name;
    public Customer(){
        this.name = "Snow";
    }
    public Customer(String name){
        this.name = name;
    }
    public String buySomething(Store store, String item){
        return this.name + " " + store.buy(item);
    }
}
