package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 字符的最短距离
 * @author snow
 * @since 2021/09/26 01:16
 */
public class P0821 {
    public static void main(String[] args) {
        P0821 main = new P0821();
        System.out.println(Arrays.toString(main.shortestToChar("loveleetcode", 'e')));
    }
    public int[] shortestToChar(String s, char c) {
        int[] answer = new int[s.length()];
        List<Integer> list = findChar(s, c, answer);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != c) {
                answer[i] = findClosest(list, i);
            }
        }
        return answer;
    }
    private List<Integer> findChar(String s, char ch, int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                arr[i] = 0;
                list.add(i);
            }
        }
        return list;
    }
    private int findClosest(List<Integer> list, int index) {
        int distance = Math.abs(list.get(0) - index);
        for (int i = 1; i < list.size(); i++) {
            distance = Math.max(distance, Math.abs(list.get(i) - index));
        }
        return distance;
    }
}
