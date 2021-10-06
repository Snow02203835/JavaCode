package code;

/**
 * 位1的个数
 * @author snow
 * @since 2021/10/06 21:16
 */
public class P0191 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }
}
