package autumn.yingjiao;

public class P1 {
    public static void main(String[] args) {
        System.out.println(mulDigits("8888"));
    }

    private static String toNight(int num) {
        StringBuilder builder = new StringBuilder();
        while (num != 0) {
            builder.insert(0, num%9);
            num /= 9;
        }
        return builder.toString();
    }

    private static String toNum(String num) {
        int sum = 1;
        for (int i = 0; i < num.length(); i++) {
            sum *= (num.charAt(i) - '0' + 1);
        }
        return toNight(sum);
    }
    public static int mulDigits(String num) {
        do {
            num = toNum(num);
            System.out.println(num);
        } while(num.length() > 1);
        return (num.charAt(0) - '0');
    }
}
