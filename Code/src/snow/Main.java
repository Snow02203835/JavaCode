package snow;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
    }

    public static int compress(char[] chars) {
        StringBuilder builder = new StringBuilder();
        int num = 1;
        char ch = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (ch == chars[i]) {
                num++;
            } else {
                builder.append(ch);
                if (num != 1){
                    builder.append(num);
                }
                num = 1;
                ch = chars[i];
            }
        }
        builder.append(ch);
        if (num != 1){
            builder.append(num);
        }
        String newStr = builder.toString();
        System.out.println(newStr);
        char[] newChar = newStr.toCharArray();
        System.arraycopy(newChar, 0, chars, 0, newStr.length());
        return newStr.length();
    }
}
