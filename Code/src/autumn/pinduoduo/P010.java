package autumn.pinduoduo;

import java.util.Arrays;
import java.util.Scanner;

public class P010 {
    public static void main(String[] args) {
        Scanner java = new Scanner(System.in);
        int group = java.nextInt();
        while (group-- != 0) {
            int num = java.nextInt();
            Goods[] goods = new Goods[num];
            int like, until;
            for (int i = 0; i < num; i++) {
                like = java.nextInt();
                until = java.nextInt();
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
            int day = 1;
            int sums = 0;
            for (Goods good : goods) {
                if (good.until >= day) {
                    sums += good.like;
                    day++;
                }
            }
            System.out.println(sums);
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
