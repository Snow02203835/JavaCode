package code;

public class P0300 {
    public int lengthOfLIS(int[] nums) {
        int maxLen = 0;
        int[] lens = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, lens[j]);
                }
            }
            lens[i] = max+1;
            maxLen = Math.max(maxLen, lens[i]);
        }
        return maxLen;
    }
}
