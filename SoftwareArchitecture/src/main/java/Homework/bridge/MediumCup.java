package Homework.bridge;

public class MediumCup extends Cup {
    @Override
    public String getDrinks(Ingredients ingredients) {
        this.ingredients = ingredients;
        return getIngredients() + "中杯饮料";
    }
}
