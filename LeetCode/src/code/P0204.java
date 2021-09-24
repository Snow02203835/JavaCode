package code;

import java.util.Arrays;

/**
 * 计数质数
 * @author snow
 * @since 2021/09/24 14:51
 */
public class P0204 {
    public static void main(String[] args) {
        P0204 main = new P0204();
        System.out.println(main.countPrimes(5000000));
    }
    public int countPrimes(int n) {
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true);
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                count++;
                for (int j = 2; i*j <= n; j++) {
                    prime[i*j] = false;
                }
            }
        }
        return count;
    }
}
