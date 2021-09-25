package code;

/**
 * 最长公共子序列
 * @author snow
 * @since 2021/09/25 10:50
 */
public class P1143 {
    public static void main(String[] args) {
        P1143 main = new P1143();
        System.out.println(main.longestCommonSubsequence("abcde", "ace"));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] map = new int[text1.length()+1][text2.length()+1];
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[i].length; j++) {
                map[i][j] = Math.max(map[i-1][j], map[i][j-1]);
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    map[i][j] = Math.max(map[i-1][j-1]+1, map[i][j]);
                }
            }
        }
        return map[text1.length()][text2.length()];
    }
}
