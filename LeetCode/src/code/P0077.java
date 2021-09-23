package code;

import util.MyMath;

import java.util.ArrayList;
import java.util.List;

public class P0077 {
    public static void main(String[] args) {
        P0077 solution = new P0077();
        System.out.println(solution.combine(2, 2));
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>(MyMath.combination(n, k));
        List<Integer> combine = new ArrayList<>(k);
        combine(answer, combine, n, 1, k);
        return answer;
    }
    private void combine(List<List<Integer>> answer, List<Integer> combine, int n, int start, int k) {
        for (int i = start; i <= n; i++) {
            combine.add(i);
            if (combine.size() == k) {
                answer.add(new ArrayList<>(combine));
            } else {
                combine(answer, combine, n, i+1, k);
            }
            combine.remove(combine.size()-1);
        }
    }
}
