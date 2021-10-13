package code;

import java.util.ArrayList;
import java.util.List;

/**
 * 拥有最多糖果的孩子
 * @author snow
 * @since 2021/10/13 17:35
 */
public class P1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        List<Boolean> answer = new ArrayList<>(candies.length);
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        for (int candy : candies) {
            answer.add(candy + extraCandies >= max);
        }
        return answer;
    }
}
