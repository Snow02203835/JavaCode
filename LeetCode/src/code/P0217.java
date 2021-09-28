package code;

import java.util.HashMap;

/**
 * 存在重复元素
 * @author snow
 * @since 2021/09/28 10:23
 */
public class P0217 {
    public boolean containsNearbyDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            } else {
                map.put(num, 1);
            }
        }
        return false;
    }
}
