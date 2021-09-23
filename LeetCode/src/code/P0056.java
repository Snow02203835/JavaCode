package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P0056 {
    public static void main(String[] args) {
        P0056 solution = new P0056();
        System.out.println(Arrays.deepToString(solution.merge(new int[][]{{1, 4}, {0, 4}})));
    }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> answer = new ArrayList<>(intervals.length);
        answer.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] an = answer.get(answer.size()-1);
            if (intervals[i][0] <= an[1]) {
                an[1] = Math.max(an[1], intervals[i][1]);
            } else {
                answer.add(intervals[i]);
            }
        }
        int[][] ans = new int[answer.size()][];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = answer.get(i);
        }
        return ans;
    }
}
