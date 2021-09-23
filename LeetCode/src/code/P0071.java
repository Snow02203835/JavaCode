package code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P0071 {
    public static void main(String[] args) {
        P0071 solution = new P0071();
        System.out.println(solution.simplifyPath("/home/////../../././___snow/vanilla/"));
    }
    public String simplifyPath(String path) {
        List<String> paths = splitBySlash(path);
        LinkedList<String> folder = new LinkedList<>();
        for (String str : paths) {
            if (str.equals("..")) {
                if (!folder.isEmpty()) {
                    folder.removeLast();
                }
            } else if (!str.equals(".")) {
                folder.add(str);
            }
        }
        if (folder.isEmpty()) {
            return "/";
        }
        StringBuilder builder = new StringBuilder();
        while (!folder.isEmpty()) {
            builder.append('/');
            builder.append(folder.pollFirst());
        }
        return builder.toString();
    }
    private List<String> splitBySlash(String path) {
        List<String> index = new ArrayList<>();
        char[] chars = path.toCharArray();
        int start = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '/') {
                if (start != -1) {
                    index.add(path.substring(start, i));
                    start = -1;
                }
            } else {
                if (start == -1) {
                    start = i;
                }
            }
        }
        if (start != -1) {
            index.add(path.substring(start));
        }
        return index;
    }
}
