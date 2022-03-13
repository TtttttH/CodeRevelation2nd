package greedy.stock;

/**
 * No.122 买卖股票的最佳时机II
 */
public class No_122 {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        int accumulate = 0;
        for (int i = 1; i < prices.length; i ++) {
            if (prices[i] > prices[i - 1]) accumulate += prices[i] - prices[i - 1];
        }

        return accumulate;
    }
}
