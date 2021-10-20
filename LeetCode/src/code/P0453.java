package code;

/**
 * 最小操作次数使数组元素相等
 * @author snow
 * @since 2021/10/20 15:14
 */
public class P0453 {
    public int minMoves(int[] nums) {
        int min = 0x7fffffff;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        int times = 0;
        for (int num : nums) {
            times += num - min;
        }
        return times;
    }
}
