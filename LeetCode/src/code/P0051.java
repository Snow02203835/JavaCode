package code;

import java.util.ArrayList;
import java.util.List;

public class P0051 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> answer = new ArrayList<>();
        solution(new int[n][n], 0, answer);
        return answer;
    }
    private static void solution(int[][] panel, int level, List<List<String>> answer) {
        if (level == panel.length) {
            List<String> list = new ArrayList<>(panel.length);
            StringBuilder builder = new StringBuilder();
            for (int[] ints : panel) {
                for (int j = 0; j < panel.length; j++) {
                    builder.append(ints[j] == 0 ? '.' : 'Q');
                }
                list.add(builder.toString());
                builder.delete(0, builder.length());
            }
            answer.add(list);
            return;
        }
        for (int i = 0; i < panel.length; i++) {
            if (canPut(panel, level, i)) {
                panel[level][i] = 1;
                solution(panel, level+1, answer);
                panel[level][i] = 0;
            }
        }
    }
    private static boolean canPut(int[][] panel, int x, int y) {
        for (int i = 0; i < panel.length; i++) {
            if (panel[x][i] == 1) {
                return false;
            }
        }
        for (int[] ints : panel) {
            if (ints[y] == 1) {
                return false;
            }
        }
        int i = x - Math.min(x, y), j = y - Math.min(x, y);
        while (i < panel.length && j < panel.length) {
            if (panel[i++][j++] == 1) {
                return false;
            }
        }
        int step = Math.min(x, panel.length-y-1);
        i = x - step;
        j = y + step;
        while (i < panel.length && j >= 0) {
            if (panel[i++][j--] == 1) {
                return false;
            }
        }
        return true;
    }
}
