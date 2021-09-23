package Homework.abstractFactory.example;

public class AbstractFactoryExampleMain {
    public static void main(String[] args) {
        create(new LinuxFactory());
        create(new WindowsFactory());
    }
    public static void create(OSFactory osFactory){
        Button button = osFactory.createButton();
        button.setName("button");
        System.out.println(button.click());
        TextField textField = osFactory.createTextField();
        textField.setName("text");
        textField.setText("Hello world");
    }
}
