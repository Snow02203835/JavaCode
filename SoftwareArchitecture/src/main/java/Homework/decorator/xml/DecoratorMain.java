package Homework.decorator.xml;

public class DecoratorMain {
    public static void main(String[] args) {
        Component xml = new XML();
        Decorate decorate = new Text(new Img(new HTML(new Text(new Img(xml)))));
        System.out.println(decorate.assemble("Hello World!"));
    }
}
