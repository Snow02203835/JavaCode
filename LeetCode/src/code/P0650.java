package code;

public class P0650 {
    public static void main(String[] args) {
        P0650 main = new P0650();
        System.out.println(main.minSteps(231));
    }
    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        int sums = 0;
        for (int i = 2; i <= n; i++) {
            while (n%i == 0) {
                n /= i;
                sums += i;
            }
        }
        return sums;
    }
}
