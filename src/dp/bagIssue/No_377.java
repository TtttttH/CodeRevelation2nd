package dp.bagIssue;

/**
 * No.377 组合总和IV (middle)
 *
 * 本题是排列问题!!!完全背包的排列问题需要将背包容量放在循环外层，内层放物品!!!
 */
public class No_377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i ++) {
            for (int num : nums) {
                if (i >= num) dp[i] += dp[i - num];
            }
        }

        return dp[target];
    }
}
