package code;

import java.util.HashMap;
import java.util.Map;

/**
 * 最短补全词
 * @author snow
 * @since 2021/10/01 16:55
 */
public class P0748 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        HashMap<Character, Integer> license = count(licensePlate);
        String answer = null;
        for (String word : words) {
            boolean match = true;
            HashMap<Character, Integer> map = count(word);
            for (Map.Entry<Character, Integer> entry : license.entrySet()) {
                if (!map.containsKey(entry.getKey()) || map.get(entry.getKey()) < entry.getValue()) {
                    match = false;
                    break;
                }
            }
            if (match && (answer == null || word.length() < answer.length())) {
                answer = word;
            }
        }
        return answer;
    }
    private HashMap<Character, Integer> count (String str) {
        HashMap<Character, Integer> map = new HashMap<>(32);
        for (char ch : str.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            } else if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }
        return map;
    }
}
