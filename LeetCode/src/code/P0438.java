package code;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到字符串中所有字母异位词
 * @author snow
 * @since 2021/10/01 19:40
 */
public class P0438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> answer = new ArrayList<>(s.length());
        if (s.length() >= p.length()) {
            char[] des = count(p);
            char[] src = count(s.substring(0, p.length()));
            int start = 0, end = p.length()-1;
            while (end < s.length()) {
                if (compare(des, src)) {
                    answer.add(start);
                }
                src[s.charAt(start++) - 'a']--;
                end++;
                if (end < s.length()) {
                    src[s.charAt(end) - 'a']++;
                }
            }
        }
        return answer;
    }
    private char[] count(String str) {
        char[] arr = new char[26];
        for (char ch : str.toCharArray()) {
            arr[ch - 'a']++;
        }
        return arr;
    }
    private boolean compare(char[] first, char[] second) {
        for (int i = 0; i < first.length; i++) {
            if (first[i] != second[i]) {
                return false;
            }
        }
        return true;
    }
}
