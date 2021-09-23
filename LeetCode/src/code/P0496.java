package code;

import java.util.HashMap;

public class P0496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>(nums2.length*3/2);
        boolean exist;
        for (int i = 0; i < nums2.length; i++) {
            exist = false;
            for (int j = i+1; j < nums2.length; j++) {
                if (nums2[j] > nums2[i]) {
                    exist = true;
                    map.put(nums2[i], nums2[j]);
                    break;
                }
            }
            if (!exist) {
                map.put(nums2[i], -1);
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }
}
