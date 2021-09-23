package code;

public class P0665 {
    public boolean checkPossibility(int[] nums) {
        if (none(nums)) {
            return true;
        }
        if (nums[0] > nums[1]) {
            int temp = nums[0];
            nums[0] = nums[1] - 1;
            if (none(nums)) {
                return true;
            } else {
                nums[0] = temp;
            }
        }
        for (int i = 1; i < nums.length - 1; i++) {
            int temp = nums[i];
            if (nums[i-1] > nums[i] && nums[i] > nums[i+1]) {
                return false;
            } else if (nums[i-1] > nums[i]) {
                nums[i] = nums[i-1];
                if (none(nums)) {
                    return true;
                }
            } else if (nums[i] > nums[i+1]) {
                nums[i] = nums[i+1];
                if (none(nums)) {
                    return true;
                }
            }
            nums[i] = temp;
        }
        if (nums[nums.length-2] > nums[nums.length-1]) {
            int temp = nums[nums.length-1];
            nums[nums.length-1] = nums[nums.length-2] + 1;
            if (none(nums)) {
                return true;
            } else {
                nums[nums.length-1] = temp;
            }
        }
        return false;
    }
    private boolean none(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] > nums[i]) {
                return false;
            }
        }
        return true;
    }
}
