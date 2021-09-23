package code;

public class P0459 {
    public boolean repeatedSubstringPattern(String s) {
        if (s != null && s.length() > 1) {
            for (int i = 2; i <= s.length(); i++) {
                if (s.length()%i == 0) {
                    boolean repeat = true;
                    int len = s.length()/i;
                    String temp = s.substring(0, len);
                    for (int j = len; j < s.length(); j += len) {
                        if (!temp.equals(s.substring(j, j+len))) {
                            repeat = false;
                            break;
                        }
                    }
                    if (repeat) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
