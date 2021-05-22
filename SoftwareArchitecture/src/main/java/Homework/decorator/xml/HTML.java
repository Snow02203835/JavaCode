package Homework.decorator.xml;

public class HTML extends Decorate {
    public HTML(Component component) {
        super(component);
    }

    @Override
    public String assemble(String content){
        return "<html>" + super.assemble(content) + "</html>";
    }
}
