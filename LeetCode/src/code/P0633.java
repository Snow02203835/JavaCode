package code;

/**
 * 平方数之和
 * @author snow
 * @since 2021/09/29 15:10
 */
public class P0633 {
    public boolean judgeSquareSum(int c) {
        long start = 0, end = (long)Math.sqrt(c), sums;
        while (start <= end) {
            sums = start*start + end*end;
            if (sums == c) {
                return true;
            } else if (sums > c) {
                end--;
            } else {
                start++;
            }
        }
        return false;
    }
}
