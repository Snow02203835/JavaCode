package code;

import java.util.*;
public class P0524{
	public static void main(String[] args) {
		List<String> list = new ArrayList<>(2);
		list.add("abe");
		list.add("abc");
		System.out.println(findLongestWord("abce", list));
	}
    public static String findLongestWord(String s, List<String> dictionary) {
        String answer = "";
        for (String dis : dictionary) {
            int i = 0;
            for (int j = 0; j < s.length(); j++) {
                if (dis.charAt(i) == s.charAt(j)) {
                    i++;
                    if (i == dis.length()) {
                        if (answer.length() < i) {
                            answer = dis;
                        } else if (answer.length() == i) {
							System.out.println("Compare" + answer + " " + dis + " " + dis.compareTo(answer));
                            if (dis.compareTo(answer) <= -1) {
                                answer = dis;
                            }
                        }
                        break;
                    }
                }
            }
        }
        return answer;
    }
}