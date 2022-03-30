package dp.stocks;

/**
 * No.309 最佳买卖股票实际含冷冻期 (middle)
 */
public class No_309 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int[][] dp = new int[prices.length][2]; // dp[i][0] 持有, dp[i][1] 不持有
        dp[0][0] = - prices[0];
        dp[1][0] = Math.max(dp[0][0], - prices[1]);
        dp[1][1] = Math.max(dp[0][1], dp[1][0] + prices[1]);
        for (int i = 2; i < dp.length; i ++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i][0] + prices[i]);
        }

        return dp[dp.length - 1][1];
    }
}
