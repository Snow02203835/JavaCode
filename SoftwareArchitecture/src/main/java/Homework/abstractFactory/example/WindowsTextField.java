package Homework.abstractFactory.example;

public class WindowsTextField extends TextField {
    @Override
    public void setText(String text) {
        content = text;
        System.out.println("Successfully set Text in '" + name + "' on Windows");
    }
}
