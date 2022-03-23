package dp;

import java.util.Arrays;

/**
 * No.322 零钱兑换(middle) 微软
 */
public class No_322 {
    public int coinChange(int[] coins, int amount) {
        //完全背包问题
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i ++) {
                if (dp[i - coin] != Integer.MAX_VALUE) dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
