package autumn.redbook;

import java.util.Scanner;

public class R0030 {
    public static void main(String[] args) {
        Scanner java = new Scanner(System.in);
        int nodeNum = java.nextInt();
        int distance = java.nextInt();
        int a, b, c;
        int[][] tree = new int[nodeNum][nodeNum];
        for (int i = 1; i < nodeNum; i++) {
            a = java.nextInt() - 1;
            b = java.nextInt() - 1;
            c = java.nextInt();
            tree[a][b] = tree[b][a] = c;
        }
        int path = 0;
        for (int i = 0; i < tree.length; i++) {
            path += reach(i, distance, tree);
        }
        System.out.println(path/2);
    }

    private static int reach(int index, int value, int[][] map) {
        int[] distance = new int[map.length];
        boolean[] choose = new boolean[map.length];
        System.arraycopy(map[index], 0, distance, 0, map.length);
        for (int i = 1; i < map.length; i++) {
            int next = pick(distance, choose);
            choose[next] = true;
            for (int j = 0; j < map.length; j++) {
                if (map[next][j] != 0 && ((distance[j] == 0 && map[next][j] != 0) || distance[j] > distance[next] + map[next][j])) {
                    distance[j] = distance[next] + map[next][j];
                }
            }
        }
        int sums = 0;
        distance[index] = 0;
        for (int d : distance) {
            if (d != 0 && d <= value) {
                sums++;
            }
        }
        return sums;
    }

    private static int pick(int[] distance, boolean[] choose) {
        int index = -1, min = 0x7fffffff;
        for (int i = 0; i < distance.length; i++) {
            if (!choose[i] && distance[i] != 0 && distance[i] < min) {
                min = distance[i];
                index = i;
            }
        }
        return index;
    }
}
