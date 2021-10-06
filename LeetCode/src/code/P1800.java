package code;

/**
 * 最大升序子数组和
 * @author snow
 * @since 2021/10/06 22:11
 */
public class P1800 {
    public int maxAscendingSum(int[] nums) {
        int max = nums[0];
        int[] answer = new int[nums.length];
        answer[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            answer[i] = nums[i] > nums[i-1] ? answer[i-1] + nums[i] : nums[i];
            max = Math.max(max, answer[i]);
        }
        return max;
    }
}
