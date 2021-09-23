package code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P0093 {
    public static void main(String[] args) {
        P0093 solution = new P0093();
        System.out.println(solution.restoreIpAddresses("101023"));
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> answer = new ArrayList<>();
        LinkedList<Integer> combination = new LinkedList<>();
        if (s.length() >= 4 && s.length() <= 16) {
            valid(answer, combination, 0, 3, s);
        }
        return answer;
    }
    private void valid(List<String> answer, LinkedList<Integer> combination, int start, int curr, String s) {
        if (combination.size() == 4) {
            answer.add(ipBuilder(combination));
            return;
        }
        for (int i = 1; i < 4; i++) {
            if (curr*4+i+start < s.length()) {
                continue;
            }
            if (s.length()-i-start < curr) {
                break;
            }
            String temp = s.substring(start, start+i);
            if (temp.length() > 1 && temp.charAt(0) == '0') {
                break;
            }
            int value = Integer.parseInt(temp);
            if (value >= 0 && value <= 255) {
                combination.add(value);
                valid(answer, combination, start+i, curr-1, s);
                combination.removeLast();
            }
        }
    }
    private String ipBuilder(List<Integer> combination) {
        StringBuilder builder = new StringBuilder();
        builder.append(combination.get(0));
        for (int i = 1; i < combination.size(); i++) {
            builder.append('.');
            builder.append(combination.get(i));
        }
        return builder.toString();
    }
}
