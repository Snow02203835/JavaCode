package code;

import util.ProcessInputString;

import java.util.HashMap;

public class P0137 {
    public static void main(String[] args) {
        P0137 main = new P0137();
        int[] vector = ProcessInputString.processVector("[2,2,3,2]");
        System.out.println(main.singleNumber(vector));
    }
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        for (Integer i : map.keySet()) {
            if (map.get(i) == 1) {
                return i;
            }
        }
        return -1;
    }
}
