package code;

import java.util.Arrays;

public class P1887 {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int min = nums[0], step = 0, sums = 0;
        for (int num : nums) {
            if (num > min) {
                step++;
                min = num;
            }
            sums += step;
        }
        return sums;
    }
}
