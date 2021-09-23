package code;

import util.ProcessInputString;

public class P1277 {
    public static void main(String[] args) {
        P1277 main = new P1277();
        System.out.println(main.countSquares(ProcessInputString.processMatrix("[[1,0,1,0,1],[1,0,0,1,1],[0,1,0,1,1],[1,0,0,1,1]]")));
    }
    public int countSquares(int[][] matrix) {
        int[][] lens = new int[matrix.length][matrix[0].length];
        int answer = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0 || j == 0) {
                    lens[i][j] = matrix[i][j];
                }
                else if (matrix[i][j] == 0) {
                    lens[i][j] = 0;
                }
                else {
                    lens[i][j] = Math.min(Math.min(lens[i][j - 1], lens[i - 1][j]), lens[i - 1][j - 1]) + 1;
                }
                answer += lens[i][j];
            }
        }
        return answer;
    }
}
