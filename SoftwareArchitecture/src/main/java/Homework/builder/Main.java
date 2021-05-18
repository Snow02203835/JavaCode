package Homework.builder;

public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        director.setBuilder(new TextBuilder());
        System.out.println(director.construct());
        director.setBuilder(new XMLBuilder());
        System.out.println(director.construct());
    }
}
