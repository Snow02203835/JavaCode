package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 分数到小数
 * @author snow
 * @since 2021/10/03 13:57
 */
public class P0166 {
    public String fractionToDecimal(int numerator, int denominator) {
        return fractionToDecimal(numerator, (long)denominator);
    }
    private String fractionToDecimal(long numerator, long denominator) {
        boolean negative = false;
        if (numerator*denominator < 0) {
            negative = true;
        }
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        long integer = numerator / denominator, repeat = -1;
        List<Long> small = new ArrayList<>();
        HashMap<Long, Integer> left = new HashMap<>();
        numerator %= denominator;
        while (numerator != 0) {
            left.put(numerator, small.size());
            numerator *= 10;
            small.add(numerator / denominator);
            numerator %= denominator;
            if (left.containsKey(numerator)) {
                repeat = left.get(numerator);
                break;
            }
        }
        StringBuilder builder = new StringBuilder();
        if ((integer != 0 || small.size() != 0) && negative) {
            builder.append('-');
        }
        builder.append(integer);
        if (small.size() != 0) {
            builder.append('.');
            for (int i = 0; i < small.size(); i++) {
                if (i != repeat) {
                    builder.append(small.get(i));
                } else {
                    builder.append('(').append(small.get(i));
                }
            }
        }
        if (repeat != -1) {
            builder.append(')');
        }
        return builder.toString();
    }
}
