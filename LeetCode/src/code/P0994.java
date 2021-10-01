package code;

import java.util.LinkedList;

/**
 * 腐烂的橘子
 * @author snow
 * @since 2021/10/01 11:33
 */
public class P0994 {
    public int orangesRotting(int[][] grid) {
        LinkedList<Point> current = find(grid, 2);
        LinkedList<Point> nextTime = new LinkedList<>();
        int times = 0;
        if (current.size() != 0) {
            times = -1;
            while (!current.isEmpty()) {
                while (!current.isEmpty()) {
                    Point point = current.poll();
                    rot(nextTime, grid, point.x, point.y);
                }
                times++;
                LinkedList<Point> temp = current;
                current = nextTime;
                nextTime = temp;
            }
        }
        if (find(grid, 1).size() != 0) {
            return -1;
        }
        return times;
    }
    private void rot(LinkedList<Point> current, int[][] grid, int x, int y) {
        if (x > 0 && grid[x-1][y] == 1) {
            grid[x-1][y] = 2;
            current.add(new Point(x-1, y));
        }
        if (x < grid.length-1 && grid[x+1][y] == 1) {
            grid[x+1][y] = 2;
            current.add(new Point(x+1, y));
        }
        if (y > 0 && grid[x][y-1] == 1) {
            grid[x][y-1] = 2;
            current.add(new Point(x, y-1));
        }
        if (y < grid[x].length-1 && grid[x][y+1] == 1) {
            grid[x][y+1] = 2;
            current.add(new Point(x, y+1));
        }
    }
    private LinkedList<Point> find(int[][] grid, int value) {
        LinkedList<Point> rot = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == value) {
                    rot.add(new Point(i, j));
                }
            }
        }
        return rot;
    }
    private static class Point {
        private final int x;
        private final int y;
        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
