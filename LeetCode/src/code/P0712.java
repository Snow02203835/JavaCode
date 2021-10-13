package code;

/**
 * 两个字符串的最小ASCII删除和
 * @author snow
 * @since 2021/10/07 16:30
 */
public class P0712 {
    public static void main(String[] args) {
        P0712 main = new P0712();
        System.out.println(main.minimumDeleteSum("let", "delete"));
    }
    public int minimumDeleteSum(String s1, String s2) {
        int[][] map = new int[s1.length()+1][s2.length()+1];
        for (int i = s1.length() - 1; i >= 0; i--) {
            map[i][s2.length()] = map[i+1][s2.length()] + s1.codePointAt(i);
        }
        for (int j = s2.length() - 1; j >= 0; j--) {
            map[s1.length()][j] = map[s1.length()][j+1] + s2.codePointAt(j);
        }
        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    map[i][j] = map[i+1][j+1];
                } else {
                    map[i][j] = Math.min(map[i+1][j] + s1.codePointAt(i), map[i][j+1] + s2.codePointAt(j));
                }
            }
        }
        return map[0][0];
    }
}
