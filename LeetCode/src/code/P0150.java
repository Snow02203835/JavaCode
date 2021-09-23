package code;

import java.util.LinkedList;

public class P0150 {
    public static void main(String[] args) {
        P0150 main = new P0150();
        System.out.println(main.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> answer = new LinkedList<>();
        for (String token : tokens) {
            if ("*".equals(token)) {
                answer.add(answer.pollLast()*answer.pollLast());
            } else if ("/".equals(token)) {
                int first = answer.pollLast();
                int second = answer.pollLast();
                answer.add(second/first);
            } else if ("+".equals(token)) {
                answer.add(answer.pollLast()+answer.pollLast());
            } else if ("-".equals(token)) {
                int first = answer.pollLast();
                int second = answer.pollLast();
                answer.add(second - first);
            } else {
                answer.add(Integer.parseInt(token));
            }
        }
        return answer.getFirst();
    }
}
