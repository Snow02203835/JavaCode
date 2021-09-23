package autumn.iqiyi;

import java.util.Scanner;

public class I010 {
    public static void main(String[] args) {
        Scanner java = new Scanner(System.in);
        while (java.hasNext()) {
            String input = java.next();
            String[] numStr = input.split(",");
            int[] num = new int[numStr.length];
            for (int i = 0; i < numStr.length; i++) {
                num[i] = Integer.parseInt(numStr[i]);
            }
            System.out.println(maxHeight(num));
        }
    }
    private static int maxHeight(int[] num) {
        if (num.length == 0 || num.length == 1) {
            return 0;
        }
        int maxH = 0;
        int start = num[0], end = num[0];
        boolean increase = num[1] >= start;
        for (int i = 1; i < num.length; i++) {
            if (increase) {
                if (num[i] >= end) {
                    end = num[i];
                    maxH = Math.max(maxH, num[i] - start);
                } else {
                    start = end = num[i];
                    increase = false;
                }
            } else {
                if (num[i] <= end) {
                    end = num[i];
                    maxH = Math.max(maxH, start - num[i]);
                } else {
                    start = end = num[i];
                    increase = true;
                }
            }
        }
        return maxH;
    }
}
