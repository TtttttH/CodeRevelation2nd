package backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * No.17 电话号码的组合 (middle) 微软
 */
public class No_17 {
    static Map<Character, String> map = new HashMap<>();
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backtrack(digits, 0);
        return result;
    }

    private void backtrack(String digits, int idx) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }

        for (char ch : map.get(digits.charAt(idx)).toCharArray()) {
            sb.append(ch);
            backtrack(digits, idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
