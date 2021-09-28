package autumn.baidu;

import java.util.Scanner;

/**
 * 百度2022秋招研发A卷(9月28场)
 * 机器人
 * @author snow
 * @since 2021/09/28 19:24
 */
public class B0010 {
    public static void main(String[] args) {
        Scanner java = new Scanner(System.in);
        String path = java.next();
        int x = 0, y = 0;
        for (char ch : path.toCharArray()) {
            if (ch == 'L') {
                --x;
            } else if (ch == 'R') {
                ++x;
            } else if (ch == 'U') {
                ++y;
            } else {
                --y;
            }
        }
        System.out.println("(" + x + "," + y + ")");
    }
}
