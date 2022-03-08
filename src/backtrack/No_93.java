package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * No.93 复原IP地址 (middle) 微软
 */
public class No_93 {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4 || s.length() > 12) return result;
        backtrack(s, 0, 0);
        return result;
    }

    private void backtrack(String s, int start, int part) {
        if (part == 4) {
            if (start == s.length()) {
                StringBuilder sb1 = new StringBuilder(sb);
                sb1.deleteCharAt(sb1.length() - 1);
                result.add(sb1.toString());
            }
            return;
        }

        for (int i = start; i < Math.min(s.length(), start + 3); i ++) {
            String str = s.substring(start, i + 1);
            if ((i > start && s.charAt(start) == '0') || Integer.parseInt(str) > 255)  break;
            sb.append(str).append('.');
            backtrack(s, i + 1, part + 1);
            sb.delete(sb.length() + start - i - 2, sb.length());
        }
    }

    public static void main(String[] args) {
        String s = "255255255255";
        String s1 = "12421212121";
        No_93 test = new No_93();
        test.restoreIpAddresses(s1);
        for (String str : test.result) {
            System.out.println(str + " || ");
        }
    }
}
