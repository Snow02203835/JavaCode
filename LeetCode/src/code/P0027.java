package code;

/**
 * 移除元素
 * @author snow
 * @since 2021/10/02 16:40
 */
public class P0027 {
    public int removeElement(int[] nums, int val) {
        int times = 0;
        int[] movement = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                movement[i] = 0;
                times++;
            } else {
                movement[i] = times;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (movement[i] != 0) {
                nums[i-movement[i]] = nums[i];
            }
        }
        return nums.length-times;
    }
}
