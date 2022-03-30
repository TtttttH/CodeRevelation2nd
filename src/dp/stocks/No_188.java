package dp.stocks;

/**
 * No.188 买卖股票的最佳时机IV (
 */
public class No_188 {
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length < 2) return 0;
        int[] dp = new int[2 * k];

        for (int i = 0; i < 2 * k; i += 2) {
            dp[i] = -prices[0];
        }

        for (int i = 1; i < prices.length; i ++) {
            for (int j = 0; j < dp.length; j += 2) {
                if (j == 0) { //第一次买入
                    dp[j] = Math.max(dp[j], -prices[i]);
                } else { //第 (j + 1) / 2 次买入
                    dp[j] = Math.max(dp[j], dp[j - 1] - prices[i]);
                }
                dp[j + 1] = Math.max(dp[j + 1], dp[j] + prices[i]); //第(j + 1)/ 2 次卖出
            }
        }

        return dp[2 * k - 1];
    }
}
