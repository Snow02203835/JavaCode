package Homework.decorator.transparency;

//抽象构件类
abstract class Component {
    public abstract void display();
}
//具体构件类（抽象构件类子类）
class ListBox extends Component {
    @Override
    public void display() {
        System.out.println("显示列表框...");
    }
}
class TextBox extends Component {
    @Override
    public void display() {
        System.out.println("显示文本框...");
    }
}
class Window extends Component {
    @Override
    public void display() {
        System.out.println("显示窗体...");
    }
}

//抽象装饰类（抽象构件子类）
class ComponentDecorator extends Component{
    private Component component;
    public ComponentDecorator(Component component){
        this.component=component;
    }
    @Override
    public void display() {
        component.display();
    }
}

//具体装饰者类（抽象装饰子类）
class BlackBorderDec extends ComponentDecorator {
    public BlackBorderDec(Component component) {
        super(component);
    }
    public void display(){
        this.setBlackBorder();
        super.display();
    }
    private void setBlackBorder() {
        System.out.println("添加了黑色边框...");
    }
}
class ScrollBarDec extends ComponentDecorator {
    public ScrollBarDec(Component component) {
        super(component);
    }
    public void display(){
        this.setScrollBar();
        super.display();
    }
    private void setScrollBar() {
        System.out.println("添加了滚动条...");
    }
}

//模拟客户端测试
public class Client {
    public static void main(String[] args) {
        Component component = new Window();
        Component comB=new ScrollBarDec(component);
        Component comBB=new BlackBorderDec(comB);
        comBB.display();
    }
}
