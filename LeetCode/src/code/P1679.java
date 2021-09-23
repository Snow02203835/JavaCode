package code;

import util.ProcessInputString;

import java.util.Arrays;

public class P1679 {
    public static void main(String[] args) {
        int[] arr = ProcessInputString.processVector("[2,4,5,3,2]");
        P1679 main = new P1679();
        System.out.println(main.maxOperations(arr, 3));
    }
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int times = 0, start = 0, end = nums.length-1;
        while (start < end) {
            if (nums[end] >= k) {
                end--;
            } else if (nums[start] >= k) {
                break;
            } else {
                while (start < end) {
                    int sum = nums[start] + nums[end];
                    if (sum == k) {
                        nums[start] = nums[end] = 0;
                        times++;
                        start++;
                        end--;
                        break;
                    } else if (sum < k){
                        start++;
                    } else {
                        end--;
                        break;
                    }
                }
            }
        }
        return times;
    }
}
