package code;

public class P0678 {
    public static void main(String[] args) {
        System.out.println(checkValidString("(*)*)"));
    }
    public static boolean checkValidString(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (!match(s.charAt(start++), s.charAt(end--))) {
                break;
            }
        }
        if (start < end) {
            return false;
        } else if (start == end) {
            return s.charAt(start) == '*';
        } else {
            return true;
        }
    }
    private static boolean match(char first, char second) {
        return (first == '(' || first == '*') && (second == ')' || second == '*');
    }
}
