package code;

public class P0014 {
    public static void main(String[] args) {
        
    }
    public String longestCommonPrefix(String[] strings) {
        if (strings == null || strings.length == 0) {
            return "";
        }
        if (strings.length > 1) {
            int end;
            for (end = 0; end < strings[0].length(); end++) {
                char ch = strings[0].charAt(end);
                for (int i = 1; i < strings.length; i++) {
                    if (end >= strings[i].length() || strings[i].charAt(end) != ch) {
                        return strings[0].substring(0, end);
                    }
                }
            }
        }
        return strings[0];
    }
}
