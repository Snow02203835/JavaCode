package code;

public class P0063 {
    public static void main(String[] args) {
        P0063 solution = new P0063();
        System.out.println(solution.uniquePathsWithObstacles(new int[][]{{0, 0, 0}}));
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = -1;
                }
            }
        }
        boolean reach = true;
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] != -1 && reach) {
                obstacleGrid[i][0] = 1;
            } else {
                reach = false;
            }
        }
        reach = true;
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] != -1 && reach) {
                obstacleGrid[0][i] = 1;
            } else {
                reach = false;
            }
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] != -1) {
                    obstacleGrid[i][j] = (obstacleGrid[i - 1][j] == -1 ? 0 : obstacleGrid[i - 1][j]) + (obstacleGrid[i][j - 1] == -1 ? 0 : obstacleGrid[i][j - 1]);
                }
            }
        }
        return Math.max(0, obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]);
    }
}
