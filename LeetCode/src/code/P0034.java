package code;

public class P0034 {
    public int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        int middle;
        while (start < end) {
            middle = (start + end) / 2;
            if (nums[middle] == target) {
                return expand(nums, middle);
            } else if (nums[middle] < target) {
                start = middle+1;
            } else {
                end = middle-1;
            }
        }
        return new int[] {-1, -1};
    }
    private int[] expand(int[] nums, int index) {
        int[] answer = new int[] {index, index};
        while (answer[0] > 0) {
            if (nums[answer[0]-1] == nums[index]) {
                --answer[0];
            } else {
                break;
            }
        }
        while (answer[1] < nums.length-1) {
            if (nums[answer[1]+1] == nums[index]) {
                ++answer[1];
            } else {
                break;
            }
        }
        return answer;
    }
}
