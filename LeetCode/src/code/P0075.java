package code;

import java.util.Arrays;

public class P0075 {
    public static void main(String[] args) {
        P0075 solution = new P0075();
        int[] colors = new int[] {2,0,2,1,1,0};
        solution.sortColors(colors);
        System.out.println(Arrays.toString(colors));
    }
    public void sortColors(int[] nums) {
        int[] colors = new int[3];
        for (int i = 0; i < nums.length; i++) {
            colors[nums[i]]++;
            nums[i] = 0;
        }
        for (int i = colors[0]; i < colors[0] + colors[1]; i++) {
            nums[i] = 1;
        }
        colors[1] += colors[0];
        for (int i = colors[1]; i < colors[1] + colors[2]; i++) {
            nums[i] = 2;
        }
    }
}
