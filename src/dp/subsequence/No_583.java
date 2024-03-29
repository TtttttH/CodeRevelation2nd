package dp.subsequence;

/**
 * No.583 两个字符串的删除操作 (middle)
 */
public class No_583 {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i ++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= n; i ++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= m; i ++) {
            for (int j = 1; j <= n; j ++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
//                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 2, Math.min(dp[i - 1][j], dp[i][j - 1]) + 1);
                }
            }
        }

        return dp[m][n];
    }
}
