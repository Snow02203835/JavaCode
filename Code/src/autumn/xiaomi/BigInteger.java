package autumn.xiaomi;

import java.util.*;

public class BigInteger {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算两个数之和
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public String add (String s, String t) {
        if (s.length() < t.length()) {
            String temp = s;
            s = t;
            t = temp;
        }
        int[] nums = new int[s.length()+1];
        for (int i = 0; i < s.length(); i++) {
            nums[i+1] = s.charAt(i) - '0';
        }
        int len = nums.length - 1;
        for (int i = t.length() - 1; i >= 0; i--) {
            int temp = t.charAt(i) - '0';
            nums[len] += temp;
            for (int j = len; j > 0; j--) {
                if (nums[j] >= 10) {
                    nums[j] -= 10;
                    nums[j-1]++;
                } else {
                    break;
                }
            }
            len--;
        }
        char[] chars;
        if (nums[0] == 0) {
            len = 1;
            chars = new char[s.length()];
        } else {
            len = 0;
            chars = new char[nums.length];
        }
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char)(nums[i+len] + '0');
        }
        return new String(chars);
    }

//    public String multiple(String )
}
