package code;

/**
 * 排序硬币
 * @author snow
 * @since 2021/10/10 17:40
 */
public class P0441 {
    public int arrangeCoins(int n) {
        int k = 1;
        int line = 0;
        while (n >= k) {
            line++;
            n -= k++;
        }
        return line;
    }
}
