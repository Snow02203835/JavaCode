package code;

public class P1410 {
    public static void main(String[] args) {
        P1410 main = new P1410();
        System.out.println(main.entityParser("&amp;gt;"));
    }
    private static final String[][] strings = new String[][] {
            {"&quot;", "\""}, {"&apos;", "'"}, {"&gt;", ">"},
            {"&lt;", "<"}, {"&frasl;", "/"}, {"&amp;", "&"}
    };
    public String entityParser(String text) {
        for (String[] string : strings) {
            text = text.replace(string[0], string[1]);
        }
        return text;
    }
}
