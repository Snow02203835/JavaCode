package code;

import java.util.HashSet;
import java.util.Set;

/**
 * 两个数组的交集
 * @author snow
 * @since 2021/09/29 16:10
 */
public class P0349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            return intersection(nums2, nums1);
        }
        Set<Integer> integers = new HashSet<>();
        for (int i : nums1) {
            integers.add(i);
        }
        Set<Integer> answer = new HashSet<>();
        for (int i : nums2) {
            if (integers.contains(i)) {
                answer.add(i);
            }
        }
        int[] list = new int[answer.size()];
        int index = 0;
        for (Integer integer : answer) {
            list[index++] = integer;
        }
        return list;
    }
}
