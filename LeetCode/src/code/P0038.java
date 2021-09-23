package code;

import java.util.*;

public class P0038 {
    public static void main(String[] args) {
        P0038 solution = new P0038();
        System.out.println(solution.countAndSay(10));
    }
    public String countAndSay(int n) {
//        Map<Integer, Integer> map = count(n);
//        Object[] keys = map.keySet().toArray();
//        Arrays.sort(keys);
//        StringBuilder builder = new StringBuilder(keys.length*2);
//        for (int i = keys.length - 1; i >= 0; i--) {
//            builder.append(map.get(keys[i]));
//            builder.append(keys[i]);
//        }
//        return builder.toString();
        String answer = "1";
        for (int i = 2; i <= n; i++) {
            answer = countAndSay(answer);
        }
        return answer;
    }
    private Map<Integer, Integer> count(int n) {
        List<Map<Integer, Integer>> answerList = new ArrayList<>();
        Map<Integer, Integer> first = new HashMap<>();
        first.put(1, 1);
        answerList.add(first);
        for (int i = 1; i < n-1; i++) {
            Map<Integer, Integer> prev = answerList.get(i-1);
            Map<Integer, Integer> current = new HashMap<>();
            for (Integer key : prev.keySet()) {
                setOrIncrease(current, key);
                setOrIncrease(current, prev.get(key));
            }
            answerList.add(current);
        }
        return answerList.get(n-2);
    }

    private void setOrIncrease(Map<Integer, Integer> map, int key) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key)+1);
        } else {
            map.put(key, 1);
        }
    }

    private String countAndSay(String str) {
        char[] chars = str.toCharArray();
        char record = chars[0];
        int times = 0;
        StringBuilder builder = new StringBuilder(str.length()*2);
        for (char ch : chars) {
            if (ch == record) {
                times++;
            } else {
                builder.append(times);
                builder.append(record);
                times = 1;
                record = ch;
            }
        }
        builder.append(times);
        builder.append(record);
        return builder.toString();
    }
}
