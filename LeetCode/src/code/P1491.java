package code;

/**
 * 去掉最高工资和最低工资后的工资平均值
 * @author snow
 * @since 2021/09/30 14:20
 */
public class P1491 {
    public double average(int[] salary) {
        int max = 0, min = 0x7fffffff;
        double sums = 0;
        for (int value : salary) {
            if (value > max) {
                max = value;
            }
            if (value < min) {
                min = value;
            }
            sums += value;
        }
        return (sums-min-max)/(salary.length-2);
    }
}
