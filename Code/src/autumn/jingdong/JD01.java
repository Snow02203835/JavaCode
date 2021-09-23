package autumn.jingdong;

import java.util.Scanner;

public class JD01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[][] arr = new int[num][2];
        for (int i = 0; i < num; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }
        System.out.println(count(arr));
    }
    private static int count(int[][] pairs) {
        int sums = 0;
        for (int i = 0; i < pairs.length-1; i++) {
            for (int j = i+1; j < pairs.length; j++) {
                if (match(pairs[i][0], pairs[i][1], pairs[j][0], pairs[j][1])) {
                    sums++;
                }
            }
        }
        return sums;
    }
    private static boolean match(int ax, int ay, int bx, int by) {
        return Math.abs(ax - bx) == Math.abs(ay - by);
    }
}
