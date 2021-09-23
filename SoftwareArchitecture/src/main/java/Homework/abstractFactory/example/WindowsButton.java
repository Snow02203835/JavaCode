package Homework.abstractFactory.example;

public class WindowsButton extends Button {
    @Override
    public String click() {
        return "Click Button '" + name + "' on Windows";
    }
}
