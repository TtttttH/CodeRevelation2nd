package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * No.763 划分字母区间
 */
public class No_763 {
    public List<Integer> partitionLabels(String s) {
//        Map<Character, Integer> charRange = new HashMap<>();
//        for (int i = s.length() - 1; i >= 0; i --) {
//            if (charRange.containsKey(s.charAt(i))) continue;
//            charRange.put(s.charAt(i), i);
//        }
        int[] hash = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i ++) {
            char ch = chars[i];
            hash[ch - 'a'] = i;
        }
        int minRange = 0, preRange = -1;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < chars.length; i ++) {
            minRange = Math.max(minRange, hash[chars[i] - 'a']);
            if (i == minRange) {
                res.add(minRange - preRange);
                preRange = minRange;
            }
        }

        return res;
    }
}
