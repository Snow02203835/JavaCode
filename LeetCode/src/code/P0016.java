package code;

import util.ProcessInputString;

import java.util.Arrays;

/**
 * 最接近的三数之和
 * @author snow
 * @since 2021/10/02 17:00
 */
public class P0016 {
    public static void main(String[] args) {
        int[] vector = ProcessInputString.processVector("[1,2,4,8,16,32,64,128]");
        P0016 main = new P0016();
        System.out.println(main.threeSumClosest(vector, 82));
    }
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closer = 0x7ffffff, two, total, last = nums.length-1;
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                two = nums[i] + nums[j];
                total = two + nums[last];
                if (total < target) {
                    closer = total;
                } else {
                    boolean update = false;
                    for (int k = j+1; k < nums.length; k++) {
                        total = two + nums[k];
                        if (Math.abs(target - total) < Math.abs(target - closer)) {
                            update = true;
                            closer = total;
                        } else if (update){
                            break;
                        }
                    }
                }
            }
        }
        return closer;
    }
}
