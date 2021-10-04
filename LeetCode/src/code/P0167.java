package code;

/**
 * 两数之和II
 * @author snow
 * @since 2021/09/29 15:05
 */
public class P0167 {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length-1, total;
        while (start < end) {
            total = numbers[start] + numbers[end];
            if (total == target) {
                break;
            } else if (total > target) {
                end--;
            } else {
                start++;
            }
        }
        return new int[] {start+1, end+1};
    }
}
