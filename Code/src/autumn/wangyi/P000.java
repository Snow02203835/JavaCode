package autumn.wangyi;

public class P000 {
    public static void main(String[] args) {
        System.out.println(findKthBit(4, 11));
    }

    static char findKthBit(int n, int k) {
        if (n == 1) {
            return 'a';
        } else {
            String str = "a";
            for (int i = 1; i < n; i++) {
                System.out.println(str);
                str = str + (char)('a' + i) + reverse(invert(str));
            }
            return str.charAt(k-1);
        }
    }
    static String invert(String str) {
        byte[] bytes = str.getBytes();
        for (int i = 0; i < str.length(); i++) {
            if (bytes[i] >= 'a' && bytes[i] <= 'm') {
                bytes[i] += ('m' - bytes[i])*2 + 1;
            } else {
                bytes[i] -= (bytes[i] - 'n')*2 + 1;
            }
        }
        return new String(bytes);
    }
    static String reverse(String str) {
        byte[] bytes = str.getBytes();
        int start = 0, end = str.length() - 1;
        while (start < end) {
            byte temp = bytes[start];
            bytes[start++] = bytes[end];
            bytes[end--] = temp;
        }
        return new String(bytes);
    }
}
