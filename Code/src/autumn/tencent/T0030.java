package autumn.tencent;

import java.util.Arrays;
import java.util.Scanner;

public class T0030 {
    public static void main(String[] args) {
        Scanner java = new Scanner(System.in);
        int num = java.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = java.nextInt();
        }
        Arrays.sort(arr);
        Div[][] map = new Div[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = i+1; j < num; j++) {
                if (i != j) {
                    int temp = div(arr[i], arr[j]);
                    map[i][j] = new Div(arr[i]/temp, arr[j]/temp);
                }
            }
        }
        int max = 0, sums;
        for (int i = 0; i < num; i++) {
            for (int j = i+1; j < num; j++) {
                if (map[i][j] != null && !map[i][j].count) {
                    sums = 1;
                    map[i][j].count = true;
                    for (int m = i; m < num; m++) {
                        for (int n = j+1; n < num; n++) {
                            if (map[m][n] != null && !map[m][n].count && map[i][j].equals(map[m][n])) {
                                sums++;
                                map[i][j].count = true;
                            }
                        }
                    }
                    max = Math.max(sums, max);
                }
            }
        }
        System.out.println(max);
    }

    private static int div(int first, int second) {
        int temp;
        if (first < second) {
            temp = first;
            first = second;
            second = temp;
        }
        while (first != 0 && second != 0) {
            temp = first%second;
            if (temp == 0) {
                return second;
            }
            first = second;
            second = temp;
        }
        return 1;
    }

    private static class Div {
        private final int child;
        private final int mom;
        private boolean count;

        public Div(int child, int mom) {
            this.child = child;
            this.mom = mom;
            count = false;
        }

        private boolean equals(Div that) {
            return this.child == that.child && this.mom == that.mom;
        }
    }
}
