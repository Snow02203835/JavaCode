package code;

import java.util.Arrays;

/**
 * 丢失的数字
 * @author snow
 * @since 2021/10/07 16:20
 */
public class P0268 {
    public int missingNumber(int[] nums) {
        return nums.length*(nums.length+1)/2 - Arrays.stream(nums).sum();
    }
}
