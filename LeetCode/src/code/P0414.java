package code;

/**
 * 第三大的数
 * @author snow
 * @since 2021/10/06 00:52
 */
public class P0414 {
    public int thirdMax(int[] nums) {
        boolean exist = false;
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;
        for (int num : nums) {
            first = Math.max(first, num);
        }
        for (int num : nums) {
            if (num != first && num > second) {
                second = num;
            }
        }
        for (int num : nums) {
            if (num != first && num != second && num > third) {
                exist = true;
                third = num;
            }
        }
        return exist ? third : first;
    }
}
