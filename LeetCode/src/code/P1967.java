package code;

public class P1967 {
    public int numOfStrings(String[] patterns, String word) {
        int sums = 0;
        for (String pattern : patterns) {
            if (word.contains(pattern)) {
                sums++;
            }
        }
        return sums;
    }
}
