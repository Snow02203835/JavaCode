package code;

public class P0162 {
    public static void main(String[] args) {
        P0162 solution = new P0162();
        System.out.println(solution.findPeakElement(new int[]{2, 1}));
    }
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int start = 0, end = nums.length - 1, middle = nums.length/2;
        while (start <= end) {
            int left = middle>0?nums[middle-1]:Integer.MIN_VALUE;
            int right = middle<end?nums[middle+1]:Integer.MIN_VALUE;
            if (nums[middle] > left && nums[middle] > right) {
                return middle;
            } else if (nums[middle] < left) {
                end = middle - 1;
            } else if (nums[middle] < right) {
                start = middle + 1;
            }
            middle = (start+end)/2;
        }
        return -1;
    }
}
