package code;

/**
 * 连续字符
 * @author snow
 * @since 2021/09/28 16:50
 */
public class P1446 {
    private static final P0809 find = new P0809();
    public int maxPower(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int len = find.findContinue(s, i);
            max = Math.max(max, len);
            i += len-1;
        }
        return max;
    }
}
