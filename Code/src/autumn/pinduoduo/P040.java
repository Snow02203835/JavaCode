package autumn.pinduoduo;

import java.util.Scanner;

public class P040 {
    public static void main(String[] args) {
        Scanner java = new Scanner(System.in);
        long group = java.nextLong();
        while (group-- != 0) {
            boolean firstCame = false;
            int sitNum = java.nextInt();
            int day = java.nextInt();
            int step = java.nextInt();
            long line = java.nextLong();
            long[] sits = new long[sitNum];
            for (int i = 0; i < day; i++) {
                long value = java.nextLong();
                int index = java.nextInt();
                sits[index] = value;
                if (!firstCame && came(sits, index, step, line)) {
                    System.out.println(i);
                    firstCame = true;
                }
            }
            if (!firstCame) {
                System.out.println(-1);
            }
        }
    }
    private static boolean came(long[] sits, int start, int step, long line) {
        int l1 = (start > step ? start - step : 0);
        int l2 = Math.min(start + step, sits.length-1);
        for (int index = l1; index <= l2; index++) {
            long sums = 0;
            long len = Math.min(index + step, sits.length-1);
            for (int i = (index > step ? index - step : 0); i <= len; i++) {
                sums += sits[i];
            }
            if (sums >= line) {
                return true;
            }
        }
        return false;
    }
}
