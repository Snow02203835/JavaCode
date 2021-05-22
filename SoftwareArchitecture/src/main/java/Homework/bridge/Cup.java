package Homework.bridge;

public abstract class Cup {
    protected Ingredients ingredients;
    public String getIngredients(){
        if (ingredients == null){
            return "什么都不加的";
        }
        else{
            return "加" + ingredients.getName() + "的";
        }
    }
    public abstract String getDrinks(Ingredients ingredients);
}
