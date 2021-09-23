package code;

public class P0004 {
    public static void main(String[] args) {
        System.out.println(minSailCost(new int[][]{
                {1,1,1,1,0},
                {0,1,0,1,0},
                {1,1,2,1,1},
                {0,2,0,0,1}
        }));
    }
    public static int minSailCost (int[][] input) {
        return minCost(0, 0, 0, 0x7fffffff, input);
    }
    private static int minCost(int start, int end, int curr, int min, int[][] input) {
        if (start == input.length-1 && end == input[0].length-1) {
            return curr;
        }
        if (start < input.length-1 && input[start+1][end] != 2) {
            curr += 2 - input[start+1][end];
            if (curr > min) {
                return min;
            } else {
                min = Math.min(min, minCost(start+1, end, curr, min, input));
            }
            curr -= 2 - input[start+1][end];
        }
        if (end < input[0].length-1 && input[start][end+1] != 2) {
            curr += 2 - input[start][end+1];
            if (curr > min) {
                return min;
            } else {
                min = Math.min(min, minCost(start, end+1, curr, min, input));
            }
        }
        return min;
    }
}
