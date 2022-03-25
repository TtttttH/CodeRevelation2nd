package dp.bagIssue;

import java.util.Arrays;

/**
 * No.416 分割等和子集 (middle)
 */
public class No_416 {
    public boolean capPartition(int[] nums) {
//        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 1) return false;
        sum /= 2;
        int[] dp = new int[sum + 1];
        for (int num : nums) {
            for (int i = sum; i >= num; i --) {
                dp[i] = Math.max(dp[i], dp[i - num] + num);
            }
        }

        return dp[sum] == sum;
    }
}
