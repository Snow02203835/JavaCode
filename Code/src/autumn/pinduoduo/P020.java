package autumn.pinduoduo;

import java.util.Scanner;

public class P020 {
    public static void main(String[] args) {
        Scanner java = new Scanner(System.in);
        int group = java.nextInt();
        while (group-- != 0) {
            int init = java.nextInt();
            int stable = java.nextInt();
            int min = 0;
            while (init < stable) {
                init*= 2;
                min++;
            }
            int step = init - stable;
            min = step/2 + (step%2 == 0 ? 0 : 1);
            System.out.println(minDay(init, stable, 0, min));
        }
    }
    private static int minDay(int init, int stable, int day, int min) {
        if (init == stable) {
            return day;
        }
        if (day > min) {
            return 0x7ffffff;
        }
        min = Math.min(minDay(init-2, stable, day+1, min), min);
        min = Math.min(minDay(init-1, stable, day+1, min), min);
        min = Math.min(minDay(init*2, stable, day+1, min), min);
        return min;
    }
}
