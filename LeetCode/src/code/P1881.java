package code;

public class P1881 {
    public String maxValue(String n, int x) {
        boolean add = false;
        if (n.charAt(0) == '-') {
            for (int i = 1; i < n.length(); i++) {
                if (x < n.charAt(i) - '0') {
                    add = true;
                    n = n.substring(0, i) + x + n.substring(i);
                    break;
                }
            }
        } else {
            for (int i = 0; i < n.length(); i++) {
                if (x > n.charAt(i) - '0') {
                    add = true;
                    n = n.substring(0, i) + x + n.substring(i);
                    break;
                }
            }
        }
        if (!add) {
            n += x;
        }
        return n;
    }
}
