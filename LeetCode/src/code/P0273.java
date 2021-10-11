package code;

/**
 * 整数转换英文表示
 * @author snow
 * @since 2021/10/11 14:27
 */
public class P0273 {
    private static final String[] FIX = new String[] {
            "Zero", "One", "Two", "Three", "Four",
            "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen",
            "Twenty", "Thirty", // 21
            "Forty", // 22
            "Fifty", // 23
            "Sixty", // 24
            "Seventy", // 25
            "Eighty", // 26
            "Ninety", // 27
            "Hundred", // 28
            "Thousand", // 29
            "Million", // 30
            "Billion" // 31
    };

    public static void main(String[] args) {
        P0273 main = new P0273();
        Ans ans = new Ans();
        String rightAns, mineAns;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            rightAns = ans.numberToWords(i);
            mineAns = main.numberToWords(i);
            if (!rightAns.equals(mineAns)) {
                System.out.println(rightAns);
                System.out.println(mineAns);
            } else {
                System.out.println(i);
            }
        }
    }
    public String numberToWords(int num) {
        StringBuilder builder = new StringBuilder();
        int[] nums = new int[4];
        for (int i = nums.length - 1; i >= 0; i--) {
            nums[i] = num%1000;
            num /= 1000;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                append(builder, numberWithinThousandToWords(nums[i]));
                if (i != nums.length-1) {
                    append(builder, FIX[31 - i]);
                }
            }
            if (i == nums.length-1 && builder.length() == 0) {
                builder.append(FIX[0]);
            }
        }
        return builder.toString();
    }
    private String numberWithinThousandToWords(int num) {
        if (num <= 20) {
            return FIX[num];
        }
        StringBuilder answer = new StringBuilder();
        if (num >= 100) {
            int hundred = num/100;
            answer.append(FIX[hundred]).append(' ').append(FIX[28]);
            num -= hundred*100;
        }
        if (num > 20) {
            int ten = num/10;
            append(answer, FIX[ten+18]);
            num -= ten*10;
        }
        if (num != 0) {
            append(answer, numberWithinThousandToWords(num));
        }
        return answer.toString();
    }
    private void append(StringBuilder builder, String str) {
        if (builder.length() != 0) {
            builder.append(' ');
        }
        builder.append(str);
    }
    private static class Ans {
        String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] thousands = {"", "Thousand", "Million", "Billion"};

        public String numberToWords(int num) {
            if (num == 0) {
                return "Zero";
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 3, unit = 1000000000; i >= 0; i--, unit /= 1000) {
                int curNum = num / unit;
                if (curNum != 0) {
                    num -= curNum * unit;
                    StringBuffer curr = new StringBuffer();
                    recursion(curr, curNum);
                    curr.append(thousands[i]).append(" ");
                    sb.append(curr);
                }
            }
            return sb.toString().trim();
        }

        public void recursion(StringBuffer curr, int num) {
            if (num < 10) {
                curr.append(singles[num]).append(" ");
            } else if (num < 20) {
                curr.append(teens[num - 10]).append(" ");
            } else if (num < 100) {
                curr.append(tens[num / 10]).append(" ");
                recursion(curr, num % 10);
            } else {
                curr.append(singles[num / 100]).append(" Hundred ");
                recursion(curr, num % 100);
            }
        }
    }
}
