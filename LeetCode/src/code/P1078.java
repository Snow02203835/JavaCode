package code;

import java.util.ArrayList;
import java.util.List;

public class P1078{
    public String[] findOcurrences(String text, String first, String second) {
		String[] words = text.split(" ");
		List<String> list = new ArrayList<>(words.length);
		for (int i = 0; i < words.length-2; i++) {
			if (first.equals(words[i]) && second.equals(words[i+1])) {
				list.add(words[i+2]);
			}
		}
		String[] answer = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
    }
}