package code;

/**
 * 解码字母到整数映射
 * @author snow
 * @since 2021/10/02 15:25
 */
public class P1309 {
    public static void main(String[] args) {
        P1309 main = new P1309();
        System.out.println(main.freqAlphabets("1326#"));
    }
    public String freqAlphabets(String s) {
        StringBuilder builder = new StringBuilder();
        int value = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '#') {
                builder.append((char)(96 + value));
                value = 0;
            } else {
                if (value >= 10) {
                    builder.append((char)('a' + value/10 - 1));
                    value %= 10;
                }
                value = value * 10 + ch - '0';
            }
        }
        if (value >= 10) {
            builder.append((char)('a' + value/10 - 1));
            value %= 10;
        }
        if (value != 0) {
            builder.append((char)('a' + value - 1));
        }
        return builder.toString();
    }
}
