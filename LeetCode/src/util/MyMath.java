package util;

public class MyMath {
    public static int combination(int n, int k) {
        int sums = 1;
        if (k == 0 || k == n) {
            return 1;
        }
        if (k == 1 || k == n-1) {
            return n;
        }
        if (k*2 > n) {
            k = n - k;
        }
        for (int i = n; i > n-k; i--) {
            sums *= i;
        }
        for (int i = 2; i <= k; i++) {
            sums /= i;
        }
        return sums;
    }
}

