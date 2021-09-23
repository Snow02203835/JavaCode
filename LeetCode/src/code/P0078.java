package code;

import java.util.ArrayList;
import java.util.List;

public class P0078 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>((int)Math.pow(2, nums.length));
        List<Integer> combine = new ArrayList<>(nums.length);
        answer.add(new ArrayList<>(combine));
        for (int i = 1; i <= nums.length; i++) {
            combine(answer, combine, nums, 0, i);
        }
        return answer;
    }
    private void combine(List<List<Integer>> answer, List<Integer> combine, int[] nums, int start, int k) {
        for (int i = start; i < nums.length; i++) {
            combine.add(nums[i]);
            if (combine.size() == k) {
                answer.add(new ArrayList<>(combine));
            } else {
                combine(answer, combine, nums, i+1, k);
            }
            combine.remove(combine.size()-1);
        }
    }
}
