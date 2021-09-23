package Homework.abstractFactory.example;

public class LinuxFactory implements OSFactory {
    @Override
    public Button createButton() {
        return new LinuxButton();
    }

    @Override
    public TextField createTextField() {
        return new LinuxTextField();
    }
}
