package code;

import java.util.Arrays;

public class P1030 {
    public static void main(String[] args) {
        P1030 main = new P1030();
        System.out.println(Arrays.deepToString(main.allCellsDistOrder(2, 2, 0, 1)));
    }
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] answer = new int[rows*cols][2];
        answer[0][0] = rCenter;
        answer[0][1] = cCenter;
        int len = 1;
        int index = 1;
        boolean more;
        do {
            more = false;
            for (int i = -len; i <= len; i++) {
                int x = rCenter + i, y = cCenter - len + Math.abs(i);
                if (within(rows, cols, x, y)) {
                    answer[index][0] = x;
                    answer[index++][1] = y;
                    more = true;
                }
                int another = cCenter + len - Math.abs(i);
                if (another != y && within(rows, cols, x, another)) {
                    answer[index][0] = x;
                    answer[index++][1] = another;
                    more = true;
                }
            }
            len++;
        } while (more);
        return answer;
    }
    private boolean within(int rows, int cols, int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
