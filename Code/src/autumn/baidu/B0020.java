package autumn.baidu;

import java.util.Scanner;

/**
 * 百度2022秋招研发A卷(9月28场)
 * K序列
 * @author snow
 * @since 2021/09/28 19:34
 */
public class B0020 {
    public static void main(String[] args) {
        Scanner java = new Scanner(System.in);
        int group = java.nextInt();
        while (group-- != 0) {
            int num = java.nextInt();
            int pick = java.nextInt();
            int[] value = new int[num+1];
            for (int i = 1; i < value.length; i++) {
                value[i] = java.nextInt();
            }
            Ans[][] arr = new Ans[pick+1][num+1];
            for (int i = 0; i < arr[0].length; i++) {
                arr[0][i] = new Ans(0, 0);
            }
            for (int i = 1; i < arr[1].length; i++) {
                if (value[i]%2 == 0) {
                    arr[1][i] = new Ans(0, 1);
                } else {
                    arr[1][i] = new Ans(1, 0);
                }
            }
            for (int i = 2; i < arr.length; i++) {
                for (int j = i; j < arr[i].length; j++) {
                    arr[i][j] = new Ans(0, 0);
                    for (int k = i-1; k < j; k++) {
                        if (value[j]%2 == 0) {
                            arr[i][j].odd = (arr[i][j].odd + arr[i-1][k].odd)%1000000007;
                            arr[i][j].even = (arr[i][j].even + arr[i-1][k].even)%1000000007;
                        } else {
                            arr[i][j].odd = (arr[i][j].odd + arr[i-1][k].even)%1000000007;
                            arr[i][j].even = (arr[i][j].even + arr[i-1][k].odd)%1000000007;
                        }
                    }
                }
            }
            long sums = 0;
            for (int i = 0; i < arr[pick].length; i++) {
                if (arr[pick][i] != null) {
                    sums += arr[pick][i].even;
                }
            }
            System.out.println(sums%1000000007);
        }
    }
    private static class Ans {
        private long odd;
        private long even;
        private Ans(long odd, long even) {
            this.odd = odd;
            this.even = even;
        }
    }
}
