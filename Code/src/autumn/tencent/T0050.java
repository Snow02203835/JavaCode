package autumn.tencent;

import java.util.Scanner;

public class T0050 {
    public static void main(String[] args) {
        Scanner java = new Scanner(System.in);
        int num = java.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = java.nextInt();
        }
        int sums = 0;
        if (num > 1) {
            sums += num-1;
            for (int i = 0; i < num; i++) {
                for (int j = i+2; j < num; j++) {
                    if (valid(arr, i, j)) {
                        sums++;
                    }
                }
            }
        }
        System.out.println(sums);
    }
    private static boolean valid (int[] arr, int start, int end) {
        int min = arr[start], secMin = arr[end];
        for (int i = start+1; i < end; i++) {
            if (arr[i] < min) {
                return false;
            }
        }
        for (int i = start+1; i < end; i++) {
            if (arr[i] < secMin) {
                return false;
            }
        }
        return true;
    }

}
