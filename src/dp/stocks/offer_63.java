package dp.stocks;

/**
 * offer.63 股票的最大利润(middle) Microsoft
 * same as No.121
 */
public class offer_63 {
    public int maxProfit(int[] prices) {
        int result = 0;
        int minprice = prices[0];
        for (int i = 1; i < prices.length; i ++) {
            minprice = Math.min(minprice, prices[i]);
            result = Math.max(result, prices[i] - minprice);
        }

        return result;
    }
}
