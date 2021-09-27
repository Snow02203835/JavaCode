package code;

import java.util.ArrayList;

/**
 * 将二进制表示减到1的步骤数
 * @author snow
 * @since 2021/09/27 17:00
 */
public class P1404 {
    public int numSteps(String s) {
        int times = 0;
        ArrayList<Integer> num = toList(s);
        while (num.size() != 1) {
            int value = num.get(num.size()-1);
            if (value == 0) {
                num.remove(num.size()-1);
            } else {
                num.set(num.size()-1, 2);
                for (int i = num.size() - 1; i >= 0; i--) {
                    if (num.get(i) == 2) {
                        num.set(i, 0);
                        if (i == 0) {
                            num.add(0, 1);
                        } else {
                            num.set(i-1, num.get(i-1)+1);
                        }
                    } else {
                        break;
                    }
                }
            }
            times++;
        }
        return times;
    }
    private ArrayList<Integer> toList(String s) {
        ArrayList<Integer> list = new ArrayList<>(s.length());
        for (char ch : s.toCharArray()) {
            list.add(ch - '0');
        }
        return list;
    }
}
