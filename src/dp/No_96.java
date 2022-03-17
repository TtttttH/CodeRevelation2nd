package dp;

/**
 * No.96 不同的二叉搜索树 (middle) 微软
 */
public class No_96 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1; //空节点一种
        dp[1] = 1; //一个节点为root
        for (int i = 2; i < n + 1; i ++) {
            for (int j = 0; j < i; j ++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }
}
