package Homework.abstractFactory.example;

public class LinuxButton extends Button {
    @Override
    public String click() {
        return "Click Button '" + name + "' on Linux";
    }
}
