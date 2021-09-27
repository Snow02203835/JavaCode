package code;

/**
 * 解码方法
 * @author snow
 * @since 2021/09/27 11:00
 */
public class P0091 {
    public static void main(String[] args) {
        P0091 main = new P0091();
        System.out.println(main.numDecodings("226"));
    }
    public int numDecodings(String s) {
        char prevCh = s.charAt(0), currCh;
        if (prevCh == '0') {
            return 0;
        }
        int prev = 1, current = 1;
        for (int i = 1; i < s.length(); i++) {
            currCh = s.charAt(i);
            int temp = current;
            if (currCh == '0') {
                if (prevCh == '1' || prevCh == '2') {
                    current = prev;
                } else {
                    return 0;
                }
            }
            else if (prevCh == '1' || (prevCh == '2' && currCh >= '1' && currCh <= '6')) {
                current = current + prev;
            }
            prev = temp;
            prevCh = currCh;
        }
        return current;
    }
}
