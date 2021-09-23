package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P0015 {
    public static void main(String[] args) {
        P0015 solution = new P0015();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        for (int first = 0; first < nums.length-2; first++) {
            if (first == 0 || nums[first] != nums[first-1]) {
                int third = nums.length - 1;
                for (int second = first+1; second < nums.length - 1; second++) {
                    if (second == first+1 || nums[second] != nums[second-1]) {
                        int sums = nums[first] + nums[second];
                        while (third > second) {
                            int total = sums + nums[third];
                            if (total == 0) {
                                List<Integer> pair = new ArrayList<>(3);
                                pair.add(nums[first]);
                                pair.add(nums[second]);
                                pair.add(nums[third]);
                                answer.add(pair);
                                --third;
                                break;
                            } else if (total > 0) {
                                --third;
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}
