package dp;

/**
 * No.746 使用最小花费爬楼梯(easy) shopee
 */
public class No_746 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n == 2) return Math.min(cost[0] ,cost[1]);
        for (int i = 3; i < n; i ++) {
            cost[i] = Math.min(cost[i - 1], cost[i - 2]) + cost[i];
        }

        return Math.min(cost[n - 1], cost[n - 2]);
    }
}
