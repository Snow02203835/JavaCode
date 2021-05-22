package Homework.bridge;

public class SmallCup extends Cup {
    @Override
    public String getDrinks(Ingredients ingredients) {
        this.ingredients = ingredients;
        return getIngredients() + "小杯饮料";
    }
}
