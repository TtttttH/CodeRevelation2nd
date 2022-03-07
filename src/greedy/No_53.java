package greedy;

/**
 * No.53 最大子数组和 (easy) 微软
 */
public class No_53 {
    public int maxSubArray(int[] nums) {
        int curMax = nums[0];
        int max = curMax;
        for (int i = 1; i < nums.length; i ++) {
            curMax = Math.max(curMax, 0) + nums[i];
            max = Math.max(curMax, max);
        }

        return max;
    }
}
