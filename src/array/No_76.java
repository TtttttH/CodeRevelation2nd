package array;

import java.util.HashMap;
import java.util.Map;

/**
 * No.76 最小覆盖子串 Minimum Window Substring (hard)
 */
public class No_76 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        int left = 0;
        int minLeft = 0;
        int minRight = 0;
        int minLen = Integer.MAX_VALUE;
        char[] schar = s.toCharArray();
        int valid = 0;
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s.length(); i ++) {
            if (tMap.containsKey(schar[i])) {
                sMap.put(schar[i], sMap.getOrDefault(schar[i], 0) + 1);
                if (tMap.get(schar[i]).equals(sMap.get(schar[i]))) valid ++;
            }

            while (valid == tMap.size()) {
                if (minLen > i - left) {
                    minLen = i - left;
                    minLeft = left;
                    minRight = i;
                }
                if (tMap.containsKey(schar[left])) {
                    if (tMap.get(schar[left]).equals(sMap.get(schar[left]))) valid --;
                    sMap.put(schar[left], sMap.get(schar[left]) - 1);
                }
                left ++;
            }
        }

        return minLen == Integer.MAX_VALUE? "" : s.substring(minLeft, minRight + 1);
    }

//    private boolean containsT(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
//        for (Character ch : tMap.keySet()) {
//            if(!sMap.containsKey(ch) || sMap.get(ch) < tMap.get(ch)) {
//                return false;
//            }
//        }
//
//        return true;
//    }

    public static void main(String[] args) {
        No_76 test = new No_76();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(test.minWindow(s, t));
    }
}
