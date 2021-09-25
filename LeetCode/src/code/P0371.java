package code;

/**
 * 两整数之和
 * @author snow
 * @since 2021/09/26 01:05
 */
public class P0371 {
    public int getSum(int a, int b) {
        int carry;
        while (b != 0) {
            carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
