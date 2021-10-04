package code;

import java.util.Arrays;

/**
 * 超级洗衣机
 * @author snow
 * @since 2021/09/29 10:10
 */
public class P0517 {
    public int findMinMoves(int[] machines) {
        int sums = Arrays.stream(machines).sum();
        if (sums%machines.length != 0) {
            return -1;
        }
        int avg = sums / machines.length;
        int ans = 0, sum = 0;
        for (int num : machines) {
            num -= avg;
            sum += num;
            ans = Math.max(ans, Math.max(Math.abs(sum), num));
        }
        return ans;
    }
}
