package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *重复的DNA序列
 * @author snow
 * @since 2021/10/08 10:05
 */
public class P0187 {
    public List<String> findRepeatedDnaSequences(String s) {
        int value;
        String temp;
        List<String> answer = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() - 9; i++) {
            temp = s.substring(i, i + 10);
            map.put(temp, (value = map.getOrDefault(temp, 0) + 1));
            if (value == 2) {
                answer.add(temp);
            }
        }
        return answer;
    }
}
