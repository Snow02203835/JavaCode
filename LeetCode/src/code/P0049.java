package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class P0049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>(strs.length);
        HashMap<String, Integer> map = new HashMap<>(strs.length);
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String newString = new String(chars);
            if (map.containsKey(newString)) {
                int index = map.get(newString);
                answer.get(index).add(str);
            } else {
                List<String> stringList = new ArrayList<>();
                stringList.add(str);
                map.put(newString, answer.size());
                answer.add(stringList);
            }
        }
        return answer;
    }
}
