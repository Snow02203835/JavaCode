package code;

/**
 * 字符串中的单词数
 * @author snow
 * @since 2021/10/07 16:00
 */
public class P0434 {
    public int countSegments(String s) {
        String[] words = s.split(" ");
        int length = 0;
        for (String word : words) {
            if(!word.equals("")){
                length++;
            }
        }
        return length;
    }
}
