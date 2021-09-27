package code;

/**
 * 解码方法II
 * @author snow
 * @since 2021/09/27 16:00
 */
public class P0639 {
    public static void main(String[] args) {
        P0639 main = new P0639();
        System.out.println(main.numDecodings("************"));
    }
    public int numDecodings(String s) {
        char prev = s.charAt(0), ch;
        if (prev == '0') {
            return 0;
        }
        long curr = 1, next = 1;
        if (prev == '*') {
            next = 9;
        }
        for (int i = 1; i < s.length(); i++) {
            ch = s.charAt(i);
            long temp = next;
            if (ch == '0') {
                temp = 0;
                if (prev == '0') {
                    return 0;
                } else if (prev == '1' || prev == '2') {
                    temp += curr;
                } else if (prev == '*') {
                    temp += curr*2;
                }
            } else if (ch == '*') {
                temp = 9*next;
                if (prev == '*') {
                    temp += 15*curr;
                } else if (prev == '1') {
                    temp += 9*curr;
                } else if (prev == '2') {
                    temp += 6*curr;
                }
            } else {
                if (prev == '*') {
                    temp += ((ch >= '0' && ch <= '6')?2:1)*curr;
                } else if (prev == '1' || (prev == '2' && ch <= '6')) {
                    temp += curr;
                }
            }
            curr = next;
            next = temp % 1000000007;
            prev = ch;
        }
        return (int)next;
    }
}
