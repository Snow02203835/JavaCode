package code;

public class P0892 {
    public int surfaceArea(int[][] grid) {
        int sums = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                sums += surface(grid, i, j);
            }
        }
        return sums;
    }
    private int surface(int[][] grid, int x, int y) {
        int sums = grid[x][y] == 0 ? 0 : 2;
        sums += x > 0 ? Math.max(grid[x][y] - grid[x-1][y], 0) : grid[x][y];
        sums += x < grid.length-1 ? Math.max(grid[x][y] - grid[x+1][y], 0) : grid[x][y];
        sums += y > 0 ? Math.max(grid[x][y] - grid[x][y-1], 0) : grid[x][y];
        sums += y < grid[x].length-1 ? Math.max(grid[x][y] - grid[x][y+1], 0) : grid[x][y];
        return sums;
    }
}
