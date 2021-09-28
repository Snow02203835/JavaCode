package code;

import java.util.HashMap;
import java.util.Map;

/**
 * 最常见的单词
 * @author snow
 * @since 2021/09/28 12:27
 */
public class P0819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> ban = new HashMap<>();
        for (String str : banned) {
            ban.put(str, 1);
        }
        paragraph = paragraph.toLowerCase();
        int index = -1;
        for (int i = 0; i < paragraph.length(); i++) {
            if (paragraph.charAt(i) >= 'a' && paragraph.charAt(i) <= 'z') {
                if (index == -1) {
                    index = i;
                }
            } else {
                if (index != -1) {
                    String temp = paragraph.substring(index, i);
                    map.put(temp, map.getOrDefault(temp, 0) + 1);
                }
                index = -1;
            }
        }
        if (index != -1) {
            String temp = paragraph.substring(index);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        int max = 0;
        String answer = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (!ban.containsKey(entry.getKey()) && max < entry.getValue()) {
                max = entry.getValue();
                answer = entry.getKey();
            }
        }
        return answer;
    }
}
