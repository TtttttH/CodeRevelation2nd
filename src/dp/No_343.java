package dp;

/**
 * No.343 整数拆分 (middle)
 */
public class No_343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i < n + 1; i ++) {
            for (int j = 1; j < i; j ++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
            System.out.println(i+": "+ dp[i]);
        }

        return dp[n];
    }

    public static void main(String[] args) {
        No_343 test = new No_343();
        test.integerBreak(10);
    }
}
