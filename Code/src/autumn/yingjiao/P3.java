package autumn.yingjiao;

public class P3 {
    public static void main(String[] args) {
        System.out.println(pathOfZeroAndOne(new int[][]{
                {0, 0, 1},
                {1, 1, 0}
        }));
    }
    public static long pathOfZeroAndOne (int[][] maze) {
        long pair = 0;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 0) {
                    if (j-1 >= 0 && maze[i][j-1] == 1){
                        pair++;
                    }
                    if (j+1 < maze[i].length && maze[i][j+1] == 1) {
                        pair++;
                    }
                    if (i-1 >= 0 && maze[i-1][j] == 1) {
                        pair++;
                    }
                    if (i+1 < maze.length && maze[i+1][j] == 1) {
                        pair++;
                    }
                }
            }
        }
        return pair;
    }
    public static int path (int[][] maze, int x, int y) {
        int pair = 0;
        if (y-1 >= 0 && maze[x][y-1] == 1){
            pair++;
            if (x-1 >= 0 && maze[x-1][y-1] == 0) {
                pair += path(maze, x-1, y-1);
            }
        }
        if (y+1 < maze[x].length && maze[x][y+1] == 1) {
            pair++;
        }
        if (x-1 >= 0 && maze[x-1][y] == 1) {
            pair++;
        }
        if (x+1 < maze.length && maze[x+1][y] == 1) {
            pair++;
        }
        return pair;
    }
}
