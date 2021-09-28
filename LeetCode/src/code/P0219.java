package code;

/**
 * 存在重复元素II
 * @author snow
 * @since 2021/09/28 10:35
 */
public class P0219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < i+k && j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
