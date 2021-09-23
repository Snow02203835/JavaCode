package autumn.bilibili;

import java.util.Scanner;

public class B010 {
    public static void main(String[] args) {
        Scanner java = new Scanner(System.in);
        int num = java.nextInt();
        while (num-- != 0) {
            String[] next = java.next().split(",");
            int max = Integer.parseInt(next[0].trim());
            int value = Integer.parseInt(next[1].trim());
//            System.out.println((max+1)*(max%2==0?max/2:max/2+1)/2 >= value);
            System.out.println(win(max, value));
        }
    }
    private static boolean win(int max, int target) {
        int sums = 0;
        boolean first = true;
        while (max > 0) {
            if (sums + max >= target) {
                return first;
            }
            first = !first;
        }
        return false;
    }
}
