package code;

/**
 * 数字的补数
 * @author snow
 * @since 2021/10/18 11:30
 */
public class P0476 {
    public int findComplement(int num) {
        int[] digital = new int[32];
        int index = 31;
        while (num != 0) {
            digital[index--] = num%2 == 1 ? 0 : 1;
            num /= 2;
        }
        int sums = 0;
        for (int i = index+1; i < digital.length; i++) {
            sums = sums*2 + digital[i];
        }
        return sums;
    }
}
