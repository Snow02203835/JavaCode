package Homework.decorator.xml;

public abstract class Decorate extends Component {
    private final Component component;
    public Decorate(Component component){
        this.component = component;
    }
    @Override
    public String assemble(String content) {
        return component.assemble(content);
    }
}
