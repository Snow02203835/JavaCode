package autumn.tencent;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class T0020 {
    public static void main(String[] args) {
        Scanner java = new Scanner(System.in);
        int num = java.nextInt();
        People[] students = new People[num];
        for (int i = 0; i < num; i++) {
            students[i] = new People(java.nextInt(), java.nextInt());
        }
        Arrays.sort(students, Comparator.comparingInt(people -> people.div));
        long sums = 0;
        for (int i = 0; i < num/2; i++) {
            sums += students[i].football;
        }
        for (int i = num/2; i < num; i++) {
            sums += students[i].basketball;
        }
        System.out.println(sums);
    }
    private static class People {
        private final int football;
        private final int basketball;
        private final int div;

        private People(int football, int basketball) {
            this.football = football;
            this.basketball = basketball;
            this.div = basketball - football;
        }
    }
}
