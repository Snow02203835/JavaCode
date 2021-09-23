package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P0057 {
    public static void main(String[] args) {
        P0057 solution = new P0057();
        System.out.println(Arrays.deepToString(solution.insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4, 8})));
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] answer = new int[intervals.length+1][];
        int index = 0;
        boolean inserted = false;
        for (int[] interval : intervals) {
            if (interval[0] >= newInterval[0] && !inserted) {
                inserted = true;
                answer[index++] = newInterval;
            }
            answer[index++] = interval;
        }
        if (index == intervals.length) {
            answer[index] = newInterval;
        }
        return merge(answer);
    }
    private int[][] merge(int[][] intervals) {
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
