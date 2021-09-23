package code;

public class P0125 {
    public boolean isPalindrome(String s) {
        StringBuilder builder = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                builder.append(ch);
            } else if (ch >= 'A' && ch <= 'Z') {
                builder.append((char)(ch + 32));
            }
        }
        return isPalindrome(builder.toString().toCharArray());
    }
    private boolean isPalindrome(char[] chars) {
        int start = 0, end = chars.length-1;
        while (start <= end) {
            if (chars[start] == chars[end]) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}
