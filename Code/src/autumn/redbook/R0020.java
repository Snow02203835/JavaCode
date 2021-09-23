package autumn.redbook;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class R0020 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        String _text;
        try {
            _text = in.nextLine();
        } catch (Exception e) {
            _text = null;
        }

        res = new Solution().partitionNumber(_text);
        System.out.println(String.valueOf(res));

    }

    private static class Solution {
        /* Write Code Here */
        public int partitionNumber(String text) {
            if (text == null || text.length() == 0) {
                return 0;
            }
            if (text.length() == 1) {
                return 1;
            }
            return -1;
        }
    }
}

