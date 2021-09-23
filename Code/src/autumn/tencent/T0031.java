package autumn.tencent;

import java.util.Arrays;
import java.util.Scanner;

public class T0031 {
    public static void main(String[] args) {
        Scanner java = new Scanner(System.in);
        int num = java.nextInt();
        long[] arr = new long[num];
        for (int i = 0; i < num; i++) {
            arr[i] = java.nextLong();
        }
        Arrays.sort(arr);
        int max = 1, sums;
        for (int i = 0; i < num; i++) {
            for (int j = i+1; j < num; j++) {
                sums = 1;
                for (int m = i; m < num; m++) {
                    for (int n = j+1; n < num; n++) {
                        if (arr[i]*arr[n] == arr[m]*arr[j]) {
                            sums++;
                        }
                    }
                }
                max = Math.max(sums, max);
            }
        }
        System.out.println(max);
    }
}
