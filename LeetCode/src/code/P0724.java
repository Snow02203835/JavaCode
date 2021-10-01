package code;

import java.util.Arrays;

/**
 * 寻找数组的中心下标
 * @author snow
 * @since 2021/10/01 17:14
 */
public class P0724 {
    public int pivotIndex(int[] nums) {
        int sums = Arrays.stream(nums).sum();
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sums - left - nums[i] == left) {
                return i;
            }
            left += nums[i];
        }
        return -1;
    }
}
