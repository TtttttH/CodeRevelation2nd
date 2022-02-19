package String;

import java.util.ArrayList;
import java.util.List;

/**
 * No.151 翻转字符串中的单词 (middle)
 */
public class No_151 {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        char[] newChars = new char[s.length() + 1];
        int newPos = 0;
        int i = s.length() - 1;
        while (i >= 0) {
            while (i >= 0 && chars[i] == ' ') i --;
            int right = i;
            while (i >= 0 && chars[i] != ' ') i --;
            for (int j = i + 1; j <=right; j ++) {
                newChars[newPos ++] = chars[j];
                if (j == right) {
                    newChars[newPos++] = ' ';
                }
            }
        }

        if (newPos == 0) {
            return String.valueOf(newChars[0]);
        }

        return new String(newChars, 0, newPos - 1);
    }
}
