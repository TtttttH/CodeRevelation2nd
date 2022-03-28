package dp.stocks;

/**
 * No.123 买卖股票的最佳时机III (卖两次) microsoft (hard)
 */
public class No_123 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int[] dp = new int[4]; //0.第一次买入, 1.第一次卖出, 2.第二次买入, 3.第二次卖出
        dp[0] = -prices[0];
        dp[2] = -prices[0];
        for (int i = 1; i < prices.length; i ++) {
            dp[0] = Math.max(dp[0], -prices[i]);
            dp[1] = Math.max(dp[1], dp[0] + prices[i]);
            dp[2] = Math.max(dp[2], dp[1] - prices[i]);
            dp[3] = Math.max(dp[3], dp[2] + prices[i]);
        }

        return dp[3];
//        int[][] dp = new int[prices.length][4];
//        dp[0][0] = -prices[0];
//        dp[0][2] = -prices[0];
//        for (int i = 1; i < prices.length; i ++) {
//            dp[i][0] = Math.max(-prices[i], dp[i - 1][0]);
//            dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
//            dp[i][2] = Math.max(dp[i][1] - prices[i], dp[i - 1][2]);
//            dp[i][3] = Math.max(dp[i - 1][2] + prices[i], dp[i - 1][3]);
//        }
//
//        return dp[prices.length - 1][3];
    }
}
