package Hash;

import java.util.*;

/**
 * No.49 字母异位词分组 middle
 */
public class No_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> results = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(str);
        }

        for (String key : map.keySet()) {
            results.add(map.get(key));
        }

        return results;
    }
}
