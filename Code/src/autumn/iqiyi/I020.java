package autumn.iqiyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class I020 {
    public static void main(String[] args) {
        Scanner java = new Scanner(System.in);
        String input = java.next();
        int num = Integer.parseInt(input.substring(2));
        List<String> answer = new ArrayList<>();
        solution(new int[num][num], 0, answer);
        System.out.print("[" + answer.get(0));
        for (int i = 1; i < answer.size(); i++) {
            System.out.print(", " + answer.get(i));
        }
        System.out.print("]");
    }
    private static void solution(int[][] panel, int level, List<String> answer) {
        if (level == panel.length) {
            StringBuilder builder = new StringBuilder();
            builder.append('[');
            for (int i = 0; i < panel.length; i++) {
                for (int j = 0; j < panel.length; j++) {
                    builder.append(panel[i][j] == 0 ? '.' : 'Q');
                }
                if (i != panel.length-1) {
                    builder.append(", ");
                } else {
                    builder.append(']');
                }
            }
            answer.add(builder.toString());
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
