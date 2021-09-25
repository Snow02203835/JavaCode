package code;

/**
 * 两个字符串的删除操作
 * @author snow
 * @since 2021/09/25 00:55
 */
public class P0583 {
    public int minDistance(String word1, String word2) {
        P1143 common = new P1143();
        int commonLength = common.longestCommonSubsequence(word1, word2);
        return word1.length()+word2.length()-2*commonLength;
    }
}
