package code;

import java.util.ArrayList;
import java.util.List;

/**
 * Fizz Buzz
 * @author snow
 * @since 2021/10/13 14:50
 */
public class P0412 {
    public List<String> fizzBuzz(int n) {
        boolean three, five;
        List<String> answer = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            three = i%3 == 0;
            five = i%5 == 0;
            if (three && five) {
                answer.add("FizzBuzz");
            } else if (three) {
                answer.add("Fizz");
            } else if (five) {
                answer.add("Buzz");
            } else {
                answer.add(String.valueOf(i));
            }
        }
        return answer;
    }
}
