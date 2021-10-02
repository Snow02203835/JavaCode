package code;

/**
 * 数字转换为十六进制数
 * @author snow
 * @since 2021/10/02 11:10
 */
public class P0405 {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        return toHex((long)num);
    }
    private String toHex(long num) {
        if (num < 0) {
            num += 0x100000000L;
        }
        StringBuilder builder = new StringBuilder();
        while (num != 0) {
            if (num%16 < 10) {
                builder.insert(0, num%16);
            } else {
                builder.insert(0, (char)('a' + num%16 - 10));
            }
            num /= 16;
        }
        return builder.toString();
    }
}
