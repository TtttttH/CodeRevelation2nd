package dp.bagIssue;

/**
 * No.494 findTargetSumWays (middle) Microsoft
 */
public class No_494 {
    public int findTargetSumWays(int[] nums, int target) {
        //divide the nums into two part, positive nums => left, negative nums => right
        // left - right = sum, left + right = target
        // 2 * left = sum + target => left + target
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < Math.abs(target) || (sum + target) % 2 == 1) return 0;
        int left = (sum + target) / 2;
        int[] dp = new int[left + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = left; i >= num; i --) {
                dp[i] += dp[i - num];
            }
        }

        return dp[left];
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        No_494 test = new No_494();
        System.out.println(test.findTargetSumWays(nums, 3));
    }
}
