package autumn.redbook;

import java.util.Scanner;

public class R0010 {
    public static void main(String[] args) {
        Scanner java = new Scanner(System.in);
        int num = java.nextInt();
        int[][] arr = new int[num][num+1];
        for (int i = 0; i < num; i++) {
            for (int j = 1; j <= num; j++) {
                arr[i][j] = arr[i][j-1] + java.nextInt();
            }
        }
        int max = 0;
        for (int i = 0; i < num; i++) {
            for (int j = 1; j <= num; j++) {
                for (int m = j; m <= num; m++) {
                    int sums = 0;
                    for (int n = i; n < num; n++) {
                        sums += arr[n][m] - arr[n][j-1];
                        max = Math.max(max, sums);
                    }
                }
            }
        }
        System.out.println(max);
    }
}
