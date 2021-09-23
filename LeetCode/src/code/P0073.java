package code;

import java.util.Arrays;

public class P0073 {
    public void setZeroes(int[][] matrix) {
        boolean[] zeroRows = new boolean[matrix.length];
        boolean[] zeroCols = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows[i] = true;
                    zeroCols[j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (zeroRows[i]) {
                Arrays.fill(matrix[i], 0);
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (zeroCols[i]) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }
}
