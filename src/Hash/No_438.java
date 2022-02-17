package Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No.438 找到字符串中所有字母异位词 (middle) 微软考过!
 */
public class No_438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> results = new ArrayList<>();
        if (s == null || s.length() < p.length()) {
            return results;
        }
        int pLen = p.length();
        int sLen = s.length();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; i ++) {
            sCount[s.charAt(i) - 'a'] ++;
            pCount[p.charAt(i) - 'a'] ++;
        }
        if (Arrays.equals(sCount, pCount)) {
            results.add(0);
        }
        for (int i = 0; i < sLen - pLen; i ++) {
            sCount[s.charAt(i) - 'a'] --;
            sCount[s.charAt(i + pLen) - 'a'] ++;
            if (Arrays.equals(sCount, pCount)) {
                results.add(i + 1);
            }
        }

        return results;
    }
}
