package Homework.decorator.xml;

public class Text extends Decorate {
    public Text(Component component) {
        super(component);
    }

    @Override
    public String assemble(String content) {
        return "<text>" + super.assemble(content) + "</text>";
    }
}
