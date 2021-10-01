package code;

/**
 * 判断一个数字是否可以表示成三的幂的和
 * @author snow
 * @since 2021/10/01 17:23
 */
public class P1780 {
    public boolean checkPowersOfThree(int n) {
        int[] arr = new int[30];
        int len = 0;
        while (n != 0) {
            arr[len++] = n%3;
            n /= 3;
        }
        for (int i = 0; i < len; i++) {
            if (arr[i] == 2) {
                return false;
            }
        }
        return true;
    }
}
