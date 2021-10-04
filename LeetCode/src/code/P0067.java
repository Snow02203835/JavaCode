package code;

/**
 * 二进制求和
 * @author snow
 * @since 2021/09/30 14:30
 */
public class P0067 {
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            return addBinary(b, a);
        }
        int[] nums = new int[a.length()+1];
        int aI = a.length()-1, bI = b.length()-1;
        for (int i = nums.length-1; i > 0; i--) {
            if (aI >= 0) {
                nums[i] += a.charAt(aI--) - '0';
            }
            if (bI >= 0) {
                nums[i] += b.charAt(bI--) - '0';
            }
            if (nums[i] >= 2) {
                nums[i-1]++;
                nums[i] %= 2;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = (nums[0] == 0 ? 1 : 0); i < nums.length; i++) {
            builder.append(nums[i]);
        }
        return builder.toString();
    }
}
