package code;

import java.util.HashMap;

/**
 * 唯一摩尔斯密码词
 * @author snow
 * @since 2021/09/28 16:30
 */
public class P0804 {
    private static final String[] morse = new String[] {
            ".-","-...","-.-.","-..",".","..-.","--.",
            "....","..",".---","-.-",".-..","--","-.",
            "---",".--.","--.-",".-.","...","-",
            "..-","...-",".--","-..-","-.--","--.."
    };
    public int uniqueMorseRepresentations(String[] words) {
        HashMap<String, Integer> map = new HashMap<>(words.length);
        for (String word : words) {
            StringBuilder builder = new StringBuilder();
            for (char ch : word.toCharArray()) {
                builder.append(morse[ch - 'a']);
            }
            map.put(builder.toString(), 1);
        }
        return map.keySet().size();
    }
}
