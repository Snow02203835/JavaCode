package Homework.bridge;

public class BigCup extends Cup {
    @Override
    public String getDrinks(Ingredients ingredients) {
        this.ingredients = ingredients;
        return getIngredients() + "大杯饮料";
    }
}
