package autumn.huawei;

public class H2108260930 {
    public String reverse(String str) {
        char[] chars = new char[str.length()];
        int[] times = new int[str.length()];
        int time = 0;
        int len = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                time++;
            } else if (str.charAt(i) == ')'){
                time--;
            } else {
                chars[len] = str.charAt(i);
                times[len++] = time;
            }
        }
        int end = len-1;
        int start = getStart(times, 0, end+1);
        while (start != -1) {
            end = getEnd(times, end);
            reverse(chars, start, end);
            for (int i = start; i <= end; i++) {
                times[i]--;
            }
            start = getStart(times, start, end+1);
        }
        char[] newStr = new char[len];
        if (len >= 0) System.arraycopy(chars, 0, newStr, 0, len);
        return new String(newStr);
    }
    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }
    private int getStart(int[] times, int start, int len) {
        while (start < len) {
            if (times[start] == 0) {
                start++;
            } else {
                return start;
            }
        }
        return -1;
    }
    private int getEnd(int[] times, int end) {
        while (end >= 0) {
            if (times[end] == 0) {
                end--;
            } else {
                return end;
            }
        }
        return -1;
    }
}
