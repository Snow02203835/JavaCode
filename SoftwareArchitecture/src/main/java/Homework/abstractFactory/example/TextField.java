package Homework.abstractFactory.example;

public abstract class TextField {
    protected String name;
    protected String content;

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public abstract void setText(String text);
}
