package code;

/**
 * 数字1的个数
 * @author snow
 * @since 2021/10/06 21:52
 */
public class P0233 {    
    int countDigitOne(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 9) {
            return 1;
        }
        String str = String.valueOf(n);  //  字符型的输入n
        int base = (str.length()-1) * (int)Math.pow(10, str.length() - 2);   // 基础

        char ch = str.charAt(0);
        if ((ch - '0') > 1) {
            return ( ch - '0') * base + (int)Math.pow(10, str.length() - 1) +
                    countDigitOne(n - (ch - '0') * (int)Math.pow(10, str.length() - 1));
        } else {
            return (base +
                    n - (ch - '0') * (int) Math.pow(10, str.length() - 1) + 1 +
                    countDigitOne(n - (ch - '0') * (int) Math.pow(10, str.length() - 1))
            );
        }
    }
}
