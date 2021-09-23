package code;

public class P0055 {
    public boolean canJump(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && !skipZero(nums, i)) {
                return false;
            }
        }
        return true;
    }
    private boolean skipZero(int[] nums, int index) {
        int len = 1;
        for (int i = index - 1; i >= 0; i--) {
            if (nums[i] > len) {
                return true;
            }
            len++;
        }
        return false;
    }
}
