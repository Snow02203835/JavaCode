package Homework.InversionOfControl;

public class Restaurant implements Store {
    private final String name;
    public Restaurant(){
        this.name = "Green Tea";
    }
    public Restaurant(String name){
        this.name = name;
    }
    @Override
    public String buy(String itemName) {
        return "order " + itemName + " in " + this.name + " Restaurant";
    }
}
