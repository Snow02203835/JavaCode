package code;

import java.util.ArrayList;
import java.util.List;

/**
 * 情感丰富的文字
 * @author snow
 * @since 2021/09/25 11:35
 */
public class P0809 {
    public static void main(String[] args) {
        String[] words = new String[] {"hello", "hi", "helo"};
        P0809 main = new P0809();
        System.out.println(main.expressiveWords("heeellooo", words));
    }
    public int expressiveWords(String S, String[] words) {
        List<Entry> list = new ArrayList<>(S.length());
        for (int i = 0; i < S.length(); i++) {
            int len = findContinue(S, i);
            list.add(new Entry(S.charAt(i), len));
            i += len-1;
        }
        int count = 0;
        for (String word : words) {
            boolean match = true;
            int i, index = 0, len;
            for (i = 0; i < word.length() && index < list.size(); i++) {
                Entry entry = list.get(index++);
                if (word.charAt(i) == entry.ch && (entry.len == (len = findContinue(word, i)) || (entry.len > len && entry.len >= 3))) {
                    i += len-1;
                } else {
                    match = false;
                    break;
                }
            }
            if (match && index == list.size() && i == word.length()) {
                count++;
            }
        }
        return count;
    }
    public int findContinue(String str, int start) {
        int len = 1;
        char ch = str.charAt(start);
        for (int i = start+1; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                len++;
            } else {
                break;
            }
        }
        return len;
    }
    private static class Entry {
        private final char ch;
        private final int len;
        private Entry(char ch, int len) {
            this.ch = ch;
            this.len = len;
        }
    }
}
