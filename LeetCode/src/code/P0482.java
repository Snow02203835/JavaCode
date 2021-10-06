package code;

/**
 * 密钥格式化
 * @author snow
 * @since 2021/10/04 22:50
 */
public class P0482 {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder builder = new StringBuilder(s.length());
        for (int i = s.length() - 1, group = 0; i >= 0; i--) {
            if (s.charAt(i) == '-') {
                continue;
            }
            if (group == k && (group = 0) >= 0) {
                builder.append('-');
            }
            builder.append(s.charAt(i));
            group++;
        }
        return builder.reverse().toString().toUpperCase();
    }
}
