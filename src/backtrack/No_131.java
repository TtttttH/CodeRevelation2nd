package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No.131 分割回文串
 */
public class No_131 {
    boolean[][] isPalindrome;
    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) return result;
        isPalindrome = isPalindrome(s);
        backtrack(s, 0);
        return result;
    }

    private void backtrack(String s, int start) {
        if (start >= s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < s.length(); i ++) {
            if (!isPalindrome[start][i]) continue;
            path.add(s.substring(start, i + 1));
            backtrack(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    private boolean[][] isPalindrome(String s) {
        int len = s.length();
        isPalindrome = new boolean[len][len];
        for (int i = 0; i < len; i ++) {
            Arrays.fill(isPalindrome[i], true);
        }

        for (int i = len - 1; i >=0; i --) {
            for (int j = i + 1; j < len; j ++) {
                isPalindrome[i][j] = s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1];
            }
        }

        return isPalindrome;
    }

}
