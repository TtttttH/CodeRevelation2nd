package dp.stocks;

/**
 * No.714 买卖股票的最佳时机含手续费(middle)
 */
public class No_714 {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length < 2) return 0;
//        int[][] dp = new int[prices.length][2];
//        dp[0][0] = -prices[0];
//        dp[0][1] = 0;
//        for (int i = 1; i < dp.length; i ++) {
//            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
//            dp[i][1] = Math.max(dp[i - 1][1], dp[i][0] + prices[i] - fee);
//        }
//
//        return dp[dp.length - 1][1];
        int[] dp = new int[2];
        dp[0] = -prices[0];
        for (int i = 1; i < prices.length; i ++) {
            dp[0] = Math.max(dp[0], dp[1] - prices[i]);
            dp[1] = Math.max(dp[1], dp[0] + prices[i] - fee);
        }

        return dp[1];
    }
}
