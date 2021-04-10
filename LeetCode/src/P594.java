import java.util.Arrays;
import java.util.Scanner;

public class P594 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrLength1 = scanner.nextInt();
        int[] arr = new int[arrLength1];
        for(int i = 0; i < arrLength1; i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println(findLHS(arr));
    }
    public static int findLHS(int[] nums) {
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;
        int maxLen = 0;
        while(nums[end] - nums[start] != 1){
            if(start+1 >= end){
                break;
            }
            for(int i = start+1; i < end; i++){
                if(nums[end] - nums[i] == 1){
                    maxLen = Math.max((end - i + 1), maxLen);
                    break;
                }
            }
            for(int i = end-1; i > start; i--){
                if(nums[i] - nums[start] == 1){
                    maxLen = Math.max((i - start + 1), maxLen);
                    break;
                }
            }
            start++;
            end--;
        }
        if(nums[end] - nums[start] == 1){
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}
