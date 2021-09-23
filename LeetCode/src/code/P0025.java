package code;

public class P0025 {
    public static void main(String[] args) {
        P0025 solution = new P0025();
        System.out.println(solution.multiply("123", "123"));
    }
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num1.equals("0")) {
            return num2;
        }
        if (num2 == null || num2.length() == 0 || num2.equals("0")) {
            return num1;
        }
        int[] first = new int[num1.length()];
        int[] second = new int[num2.length()];
        int[] answer = new int[num1.length()+num2.length()];
        for (int i = 0; i < first.length; i++) {
            first[i] = num1.charAt(i) - '0';
        }
        for (int i = 0; i < second.length; i++) {
            second[i] = num2.charAt(i) - '0';
        }
        int end = answer.length-1;
        for (int i = second.length - 1; i >= 0; i--) {
            int k = end;
            for (int j = first.length - 1; j >= 0; j--) {
                answer[k--] += first[j] * second[i];
            }
            --end;
        }
        for (int i = answer.length - 1; i > 0; i--) {
            if (answer[i] >= 10) {
                answer[i-1] += answer[i]/10;
                answer[i] %= 10;
            }
        }
        StringBuilder builder = new StringBuilder(answer.length);
        for (int i = answer[0] == 0 ? 1 : 0; i < answer.length; i++) {
            builder.append(answer[i]);
        }
        return builder.toString();
    }
}
