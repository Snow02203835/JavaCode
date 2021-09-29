package code;

/**
 * 检查某单词是否等于两单词之和
 * @author snow
 * @since 2021/09/29 15:55
 */
public class P1880 {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return toNum(firstWord) + toNum(secondWord) == toNum(targetWord);
    }
    private int toNum(String word) {
        StringBuilder builder = new StringBuilder();
        for (char ch : word.toCharArray()) {
            builder.append(ch - 'a');
        }
        return Integer.parseInt(builder.toString());
    }
}
