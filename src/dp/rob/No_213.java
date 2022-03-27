package dp.rob;

/**
 * No.213 打家劫舍II (middle)
 */
public class No_213 {
    public int rob(int[] nums) {
        if (nums.length < 2) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length - 1; i ++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        int temp = dp[nums.length - 2];

        dp[0] = 0;
        dp[1] = nums[1];
        for (int i = 2; i < nums.length; i ++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return Math.max(temp, dp[nums.length - 1]);
    }
}
