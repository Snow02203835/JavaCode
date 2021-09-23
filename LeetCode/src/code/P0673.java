package code;

import util.ProcessInputString;

public class P0673 {

    public static void main(String[] args) {
        P0673 main = new P0673();
        System.out.println(main.findNumberOfLIS(ProcessInputString.processVector("[1,3,5,4,7]")));
    }
    public int findNumberOfLIS(int[] nums) {
        int maxLen = 0, answer = 0;
        int[] lens = new int[nums.length];
        int[] count = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            lens[i] = 1;
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (lens[j] + 1 > lens[i]) {
                        lens[i] = lens[j] + 1;
                        count[i] = count[j];
                    } else if (lens[j] + 1 == lens[i]) {
                        count[i] += count[j];
                    }
                }
            }
            if (lens[i] > maxLen) {
                maxLen = lens[i];
                answer = count[i];
            } else if (lens[i] == maxLen) {
                answer += count[i];
            }
        }
        return answer;
    }
}
