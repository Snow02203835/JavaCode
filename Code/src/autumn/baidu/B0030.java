package autumn.baidu;

import java.util.Scanner;

/**
 * 百度2022秋招研发A卷(9月28场)
 * 收藏
 * @author snow
 * @since 2021/09/28 20:10
 */
public class B0030 {
    public static void main(String[] args) {
        Scanner java = new Scanner(System.in);
        int num = java.nextInt();
        Goods[] goods = new Goods[num+1];
        for (int i = 1; i < goods.length; i++) {
            goods[i] = new Goods(java.nextInt(), java.nextInt());
        }
        int[][] cost = new int[num+1][num+1];
        for (int i = 1; i < cost.length; i++) {
            for (int j = i; j < cost[i].length; j++) {
                cost[i][j] = cost[i-1][j-1];
                if (i%2 != 0) {
                    cost[i][j] += goods[j].getPrice(i-1);
                }
                if (cost[i][j-1] != 0) {
                    cost[i][j] = Math.min(cost[i][j-1], cost[i][j]);
                }
            }
        }
        System.out.println(cost[num][num]);
    }
    private static class Goods {
        private final int init;
        private final int rise;
        private Goods(int init, int rise) {
            this.init = init;
            this.rise = rise;
        }
        private int getPrice(int day) {
            return init+day*rise;
        }
    }
}
