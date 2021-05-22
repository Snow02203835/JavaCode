package Homework.bridge;

public class LargeCup extends Cup {
    @Override
    public String getDrinks(Ingredients ingredients) {
        this.ingredients = ingredients;
        return getIngredients() + "超大杯饮料";
    }
}
