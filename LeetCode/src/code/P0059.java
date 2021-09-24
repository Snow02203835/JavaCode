package code;

/**
 * 螺旋矩阵
 * @author snow
 * @since 2021/09/17 00:43
 */
public class P0059 {

    public int[][] generateMatrix(int n) {
        int[][] map = new int[n][n];
        int start = 1;
        for (int i = 0; i < (n%2==0?n/2:n/2+1); i++) {
            start = circle(map, i, start);
        }
        return map;
    }

    private int circle(int[][] map, int start, int next) {
        int len = map.length - start*2;
        for (int i = start; i < start + len; i++) {
            map[start][i] = next++;
        }
        for (int i = start+1; i < start + len; i++) {
            map[i][start+len-1] = next++;
        }
        for (int i = start + len - 1; i >= start; i--) {
            map[start+len-1][i] = next++;
        }
        for (int i = start + len - 2; i > start; i--) {
            map[i][start] = next++;
        }
        return next;
    }
}
