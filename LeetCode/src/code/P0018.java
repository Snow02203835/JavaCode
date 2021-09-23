package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P0018 {
    public static void main(String[] args) {
        P0018 solution = new P0018();
        int[] quest = new int[200];
        for (int i = 0; i < quest.length; i++) {
            quest[i] = i;
        }
//        System.out.println(Arrays.toString(quest));
        System.out.println(solution.fourSum(quest, 123));
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        if (nums != null && nums.length >= 4) {
            Arrays.sort(nums);
            for (int first = 0; first < nums.length - 3; first++) {
                if (first == 0 || nums[first] != nums[first-1]) {
                    for (int second = first+1; second < nums.length - 2; second++) {
                        if (second == first+1 || nums[second] != nums[second-1]) {
                            int sumsOfTwo = nums[first] + nums[second];
                            for (int third = second+1; third < nums.length - 1; third++) {
                                if (third == second+1 || nums[third] != nums[third-1]) {
                                    int sumsOfThree = sumsOfTwo + nums[third];
                                    for (int forth = third+1; forth < nums.length; forth++) {
                                        if (forth == third+1 || nums[forth] != nums[forth-1]) {
                                            int total = sumsOfThree + nums[forth];
                                            if (total == target) {
                                                List<Integer> pair = new ArrayList<>(4);
                                                pair.add(nums[first]);
                                                pair.add(nums[second]);
                                                pair.add(nums[third]);
                                                pair.add(nums[forth]);
                                                answer.add(pair);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}
