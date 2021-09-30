package code;

/**
 * 平衡括号字符串的最少插入次数
 * @author snow
 * @since 2021/09/29 17:10
 */
public class P1541 {
    private static final P0809 find = new P0809();

    public static void main(String[] args) {
        P1541 main = new P1541();
        System.out.println(main.minInsertions("(((()(()((())))(((()())))()())))(((()(()()((()()))"));
    }
    public int minInsertions(String s) {
        int i = 0, len, times = 0, right = 0, left;
        while (i < s.length()) {
            len = find.findContinue(s, i);
            if (s.charAt(i) == '(') {
                right += len;
            } else {
                left = len;
                if (left % 2 == 1) {
                    ++left;
                    times++;
                }
                if (left > right*2) {
                    times += left/2 - right;
                    right = 0;
                } else if (left < right*2) {
                    right -= left/2;
                } else {
                    right = 0;
                }
            }
            i += len;
        }
        if (right != 0) {
            times += right*2;
        }
        return times;
    }
}
