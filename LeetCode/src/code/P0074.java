package code;

import util.ProcessInputString;

public class P0074 {
    public static void main(String[] args) {
        int[][] input = ProcessInputString.processMatrix("[[1,3,5,7],[10,11,16,20],[23,30,34,60]]");
        P0074 solution = new P0074();
        System.out.println(solution.searchMatrix(input, 70));
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int startRow = 0, endRow = matrix.length-1;
        int startCol = 0, endCol = matrix[0].length-1;
        int middleRow = 0, middleCol;
        while (startRow <= endRow) {
            middleRow = (startRow+endRow)/2;
            if (matrix[middleRow][startCol] <= target && target <= matrix[middleRow][endCol]) {
                break;
            } else if (middleRow > 0 && matrix[middleRow-1][endCol] >= target) {
                endRow = middleRow-1;
            } else if (middleRow < matrix.length-1 && target >= matrix[middleRow+1][0]) {
                startRow = middleRow+1;
            } else {
                startRow++;
                endRow--;
            }
        }
        if (startRow <= endRow) {
            while (startCol <= endCol) {
                middleCol = (startCol+endCol)/2;
                if (matrix[middleRow][middleCol] == target) {
                    return true;
                } else if (matrix[middleRow][middleCol] < target) {
                    startCol = middleCol + 1;
                } else {
                    endCol = middleCol - 1;
                }
            }
        }
        return false;
    }
}
