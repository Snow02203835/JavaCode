package code;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 反转每对括号间的子串
 * @author snow
 * @since 2021/10/02 16:22
 */
public class P1190 {
    public static void main(String[] args) {
        P1190 main = new P1190();
        System.out.println(main.reverseParentheses("(((l)o)ve)"));
    }
    public String reverseParentheses(String s) {
        char[] chars = new char[s.length()];
        LinkedList<Integer> starts = new LinkedList<>();
        int index = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                starts.add(index);
            } else if (ch == ')') {
                reverse(chars, starts.pollLast(), index-1);
            } else {
                chars[index++] = ch;
            }
        }
        return new String(Arrays.copyOfRange(chars, 0, index));
    }
    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char ch = chars[start];
            chars[start++] = chars[end];
            chars[end--] = ch;
        }
    }
}
