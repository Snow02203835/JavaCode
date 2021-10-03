package code;

import java.util.Arrays;

/**
 * 数组中最大数对和的最小值
 * @author snow
 * @since 2021/10/03 17:36
 */
public class P1877 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        int start = 0, end = nums.length-1;
        while (start < end) {
            max = Math.max(max, nums[start++] + nums[end--]);
        }
        return max;
    }
}
