package dp.bagIssue;

import java.util.Arrays;

/**
 * No.279 完全平方数(middle) Microsoft
 */
public class No_279 {
    public int numSquares(int n) {
        if (n < 5) return 1;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < n / 2; i ++) {
            for (int j = i * i; j <= n; j ++) {
                dp[i] = Math.min(dp[i], dp[i - i * i] + 1);
            }
        }

        return dp[n];
    }
}
