package code;

/**
 * 分割数组
 * @author snow
 * @since 2021/10/03 17:25
 */
public class P0915 {
    public int partitionDisjoint(int[] nums) {
        int[] min = new int[nums.length];
        min[min.length-1] = nums[min.length-1];
        for (int i = nums.length - 2; i > 0; i--) {
            min[i] = Math.min(nums[i], min[i + 1]);
        }
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, nums[i]);
            if (max < min[i+1]) {
                return i+1;
            }
        }
        return 0;
    }
}
