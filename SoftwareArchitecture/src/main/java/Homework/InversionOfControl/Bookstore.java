package Homework.InversionOfControl;

public class Bookstore implements Store {
    private final String name;
    public Bookstore() {
        this.name = "Once";
    }
    public Bookstore(String name){
        this.name = name;
    }
    @Override
    public String buy(String itemName) {
        return "buy " + itemName + " in " + this.name + " BookStore";
    }
}
