package Homework.builder;

public class TextBuilder implements Builder {

    private final StringBuffer buffer;

    public TextBuilder(){
        buffer = new StringBuffer();
    }

    @Override
    public void makeTitle(String title) {
        buffer.append("==========================\n[");
        buffer.append(title);
        buffer.append("]\n");
    }

    @Override
    public void makeString(String str) {
        buffer.append('@');
        buffer.append(str);
        buffer.append("@\n");
    }

    @Override
    public void makeItems(String[] items) {
        for (String item : items){
            buffer.append("#").append(item).append("#\n");
        }
    }

    @Override
    public Object getResult() {
        buffer.append("==========================\n");
        return buffer.toString();
    }
}
