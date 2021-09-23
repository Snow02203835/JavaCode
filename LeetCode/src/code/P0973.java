package code;

import java.util.Arrays;

public class P0973 {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (first, second) -> {
            int fS = first.indexOf(' '), sS = second.indexOf(' ');
            String fC = first.substring(fS+1);
            String sC = second.substring(sS+1);
            if (isDigit(fC.charAt(0))) {
                if (isDigit(sC.charAt(0))) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                if (isDigit(sC.charAt(0))) {
                    return -1;
                } else {
                    int com = fC.compareTo(sC);
                    if (com == 0) {
                        com = first.substring(0, fS).compareTo(second.substring(0, sS));
                    }
                    return com;
                }
            }
        });
        return logs;
    }
    private boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }
}
