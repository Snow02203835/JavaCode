package code;

public class P0165 {
    public int compareVersion(String version1, String version2) {
        String[] versionCode1 = version1.split("\\.");
        String[] versionCode2 = version2.split("\\.");
        int len = Math.max(versionCode1.length, versionCode2.length);
        for (int i = 0; i < len; i++) {
            int first = i < versionCode1.length ? Integer.parseInt(versionCode1[i]) : 0;
            int second = i < versionCode2.length ? Integer.parseInt(versionCode2[i]) : 0;
            if (first < second) {
                return -1;
            }
            if (first > second) {
                return 1;
            }
        }
        return 0;
    }
}
