package Homework.decorator.xml;

public class XML extends Component {
    @Override
    public String assemble(String content) {
        return "<xml>" + content + "</xml>";
    }
}
