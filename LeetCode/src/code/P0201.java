package code;

/**
 * 数字范围按位与
 * @author snow
 * @since 2021/09/24 14:13
 */
public class P0201 {
    public static void main(String[] args) {
        P0201 main = new P0201();
        System.out.println(main.rangeBitwiseAnd(2147483646, 2147483647));
    }
    public int rangeBitwiseAnd(int left, int right) {
        int answer = left;
        for (int i = left+1; i <= right && i >= 0; i++) {
            answer = answer&i;
            if (answer == 0) {
                break;
            }
        }
        return answer;
    }
}
