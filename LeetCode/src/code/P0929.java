package code;

import java.util.HashMap;

public class P0929 {
    public int numUniqueEmails(String[] emails) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < emails.length; i++) {
            String[] email = emails[i].split("@");
            int indexOfPlus = email[0].indexOf('+');
            if (indexOfPlus != -1) {
                email[0] = email[0].substring(0, indexOfPlus);
            }
            email[0] = email[0].replace(".", "");
            emails[i] = email[0] + '@' + email[1];
            map.put(emails[i], 1);
        }
        return map.keySet().size();
    }
}
