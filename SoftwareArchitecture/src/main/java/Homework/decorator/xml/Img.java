package Homework.decorator.xml;

public class Img extends Decorate {
    public Img(Component component) {
        super(component);
    }

    @Override
    public String assemble(String content) {
        return "<img>" + super.assemble(content) + "</img>";
    }
}
