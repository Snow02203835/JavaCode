package Homework.bridge;

import java.util.List;
import java.util.ArrayList;

public class BridgeMain {
    public static void main(String[] args) {
        List<Cup> cups = new ArrayList<>(4);
        List<Ingredients> ingredients = new ArrayList<>(4);
        cups.add(new SmallCup());
        cups.add(new MediumCup());
        cups.add(new BigCup());
        cups.add(new LargeCup());
        ingredients.add(null);
        ingredients.add(new Milk());
        ingredients.add(new Sugar());
        ingredients.add(new Ormosia());
        for (Cup cup : cups){
            for (Ingredients ingredient : ingredients){
                System.out.println(cup.getDrinks(ingredient));
            }
        }
    }
}
