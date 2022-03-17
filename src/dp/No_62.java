package dp;

import java.util.Arrays;

/**
 * No.62 不同路径(middle) 微软
 */
public class No_62 {
    public int uniquePaths(int m, int n) {
//        int[][] dp = new int[m][n];
//        Arrays.fill(dp[0], 1);
//        for (int i = 1; i < m; i ++) {
//            dp[i][0] = 1;
//        }
//
//        for (int i = 1; i < m; i ++) {
//            for (int j = 1; j < n; j ++) {
//                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
//            }
//        }
//
//        return dp[m - 1][n - 1];
        //优化空间复杂度
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
