package String;

/**
 * No.459 重复的子字符串 (easy)
 */
public class No_459 {

    private boolean kmp(String query, String pattern) {
        int j = -1;
        int[] next = new int[pattern.length()];
        next[0] = j;
        for (int i = 1; i < pattern.length(); i ++) {
            while (j >= 0 && pattern.charAt(i) != pattern.charAt(j + 1)) {
                j = next[j];
            }

            if (pattern.charAt(i) == pattern.charAt(j + 1)) {
                j ++;
            }

            next[i] = j;
        }

        j = -1;
        for (int i = 1; i < query.length() - 1; i ++) {
            while (j >= 0 && query.charAt(i) != pattern.charAt(j + 1)) {
                j = next[j];
            }

            if (query.charAt(i) == pattern.charAt(j + 1)) {
                j ++;
            }

            if (j == pattern.length() - 1) return true;
        }

        return false;
    }
    public boolean repeatedSubstringPattern(String s) {
        return kmp(s + s, s);
    }
}
