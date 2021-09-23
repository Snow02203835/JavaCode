package autumn.pinduoduo;

import java.util.Arrays;
import java.util.Scanner;

public class P011 {
    public static void main(String[] args) {
        Scanner java = new Scanner(System.in);
        int group = java.nextInt();
        while (group-- != 0) {
            int num = java.nextInt();
            Goods[] goods = new Goods[num];
            int like, until;
            int maxDay = 0;
            for (int i = 0; i < num; i++) {
                like = java.nextInt();
                until = java.nextInt();
                maxDay = Math.max(maxDay, until);
                goods[i] = new Goods(like, until);
            }
            Arrays.sort(goods, (o1, o2) -> {
                if (o1.until > o2.until) {
                    return 1;
                } else if (o1.until == o2.until){
                    return Integer.compare(o2.like, o1.like);
                } else {
                    return -1;
                }
            });
            int[][] arr = new int[maxDay+1][goods.length+1];
            for (int i = 1; i <= maxDay; i++) {
                for (int j = 1; j <= goods.length; j++) {
                    if (goods[j-1].until >= i) {
                        arr[i][j] = Math.max(arr[i][j-1], goods[j-1].like + arr[i-1][j-1]);
                    } else {
                        arr[i][j] = Math.max(arr[i][j-1], arr[i-1][j]);
                    }
                }
            }
            System.out.println(arr[maxDay][goods.length]);
        }
    }
    static class Goods {
        private final int like;
        private final int until;

        private Goods(int like, int until) {
            this.like = like;
            this.until = until;
        }
    }
}
