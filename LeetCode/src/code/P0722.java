package code;

import java.util.ArrayList;
import java.util.List;

/**
 * 删除注释
 * @author snow
 * @since 2021/10/03 17:45
 */
public class P0722 {
    public static void main(String[] args) {
        P0722 main = new P0722();
        System.out.println(main.removeComments(new String[]{
                "a//*b/*/c", "blank", "d/*/e/*/f"
        }));
    }
    public List<String> removeComments(String[] source) {
        List<String> answer = new ArrayList<>(source.length);
        StringBuilder builder = new StringBuilder();
        boolean multiComment = false;
        for (String str : source) {
            if (!multiComment) {
                builder.delete(0, builder.length());
            }
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == '/' && i + 1 < str.length()) {
                    if (str.charAt(i+1) == '/') {
                        if (!multiComment) {
                            break;
                        }
                    } else if (!multiComment && str.charAt(i+1) == '*') {
                        i++;
                        multiComment = true;
                    } else if (!multiComment){
                        builder.append(ch);
                    }
                } else if (ch == '*' && i + 1 < str.length() && str.charAt(i+1) == '/') {
                    if (multiComment) {
                        i++;
                        multiComment = false;
                    } else {
                        builder.append(ch);
                    }
                } else if (!multiComment){
                    builder.append(ch);
                }
            }
            if (!multiComment && builder.length() != 0) {
                answer.add(builder.toString());
            }
        }
        return answer;
    }
}
