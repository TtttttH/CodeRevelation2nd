package dp.bagIssue;

/**
 * No.474 一和零
 */
public class No_474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (String str : strs) {
            int one = 0, zero = 0;
            for (char ch : str.toCharArray()) {
                if (ch == '0') zero ++;
                else one ++;
            }

            for (int i = m; i >= one; i --) {
                for (int j = n; j >= zero; j --) {
                    dp[i][j] += dp[i - one][j - zero];
                }
            }
        }

        return dp[m][n];
    }
}
