package Homework.builder;

public class XMLBuilder implements Builder {
    private final StringBuffer buffer;

    public XMLBuilder(){
        buffer = new StringBuffer();
        buffer.append("<content>\n");
    }

    @Override
    public void makeTitle(String title) {
        buffer.append("\t<title>").append(title).append("</title>\n");
    }

    @Override
    public void makeString(String str) {
        buffer.append("\t<string>").append(str).append("</string>\n");
    }

    @Override
    public void makeItems(String[] items) {
        buffer.append("\t<items>\n");
        for (String item : items){
            buffer.append("\t\t<item>").append(item).append("</item>\n");
        }
        buffer.append("\t</items>\n");
    }

    @Override
    public Object getResult() {
        buffer.append("</content>\n");
        return buffer.toString();
    }
}
