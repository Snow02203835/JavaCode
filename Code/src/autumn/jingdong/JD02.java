package autumn.jingdong;

import java.util.Scanner;

public class JD02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        String str = scanner.next();
        int[][] counts = new int[len][2];
        if (str.charAt(0) == '0') {
            counts[0][0]++;
        } else {
            counts[0][1]++;
        }
        for (int i = 1; i < len; i++) {
            counts[i][0] = counts[i-1][0];
            counts[i][1] = counts[i-1][1];
            if (str.charAt(i) == '0') {
                counts[i][0]++;
            } else {
                counts[i][1]++;
            }
        }
        System.out.print(split(counts, 1));
        for (int i = 2; i <= len; i++) {
            System.out.print(" " + split(counts, i));
        }
    }
    private static int split(int[][] counts, int len) {
        if (len == 1) {
            return 1;
        }
        int sums = 1;
        int total0 = counts[len-1][0], total1 = counts[len-1][1];
        for (int i = 1; i < len; i++) {
            if (counts[i-1][0]*(total1-counts[i-1][1]) == counts[i-1][1]*(total0-counts[i-1][0])) {
                sums++;
            }
        }
        return sums;
    }
}
