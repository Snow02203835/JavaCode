package code;

import java.util.HashMap;

/**
 * 连续数组
 * @author snow
 * @since 2021/09/28 17:05
 */
public class P0525 {
    public static void main(String[] args) {
        P0525 main = new P0525();
        System.out.println(main.findMaxLength(new int[]{0, 1}));
    }
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int counter = 0;
        map.put(counter, -1);
        for (int i = 0; i < nums.length; i++) {
            counter = nums[i] == 1 ? counter + 1 : counter - 1;
            if (map.containsKey(counter)) {
                int prevIndex = map.get(counter);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                map.put(counter, i);
            }
        }
        return maxLength;
    }
}
