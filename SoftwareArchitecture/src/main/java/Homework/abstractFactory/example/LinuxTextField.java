package Homework.abstractFactory.example;

public class LinuxTextField extends TextField {
    @Override
    public void setText(String text) {
        content = text;
        System.out.println("Successfully set Text in '" + name + "' on Linux");
    }
}
