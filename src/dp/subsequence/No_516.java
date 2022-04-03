package dp.subsequence;

/**
 * No.516 最长回文子序列(middle)
 */
public class No_516 {
    public int longestPalindromeSubseq(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int[][] dp = new int[len][len];

        for (int i = len - 1; i >= 0; i --) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j ++) {
                if (chars[i] == chars[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][len - 1];
    }
}
