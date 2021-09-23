package code;

public class P1945 {
    public int getLucky(String s, int k) {
        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char ch : chars) {
            builder.append(ch - 'a' + 1);
        }
        while (k-- != 0) {
            chars = builder.toString().toCharArray();
            int sums = 0;
            for (char ch : chars) {
                sums += ch - '0';
            }
            builder.delete(0, chars.length);
            builder.append(sums);
        }
        return Integer.parseInt(builder.toString());
    }
}
