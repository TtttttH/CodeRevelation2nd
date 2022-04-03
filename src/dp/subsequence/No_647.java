package dp.subsequence;

/**
 * No.647 回文子串 (middle)
 * 回文串系列(no.5, no.647, no.516)
 */
public class No_647 {
    public int countSubstrings(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int count = 0;
        for (int i = len - 1; i >= 0; i --) {
            for (int j = i; j < len; j ++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    count ++;
                }
            }
        }

        return count;
    }

    //中心扩散法
    int num = 0;
    public int countSubstrings2(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i ++) {
            helper(chars, i, i);
            helper(chars, i, i + 1);
        }

        return num;
    }

    private void helper(char[] s, int left, int right) {
        while (left >=0 && right < s.length && s[left] == s[right]) {
            num ++;
            left --;
            right ++;
        }
    }
}
