package dp.subsequence;

import java.util.Arrays;

/**
 * No.674 Longest Continuous increasing Subsequence (easy)
 */
public class No_674 {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;
//        int[] dp = new int[n];
//        Arrays.fill(dp, 1);
//        int res = 1;
//        for (int i = 1; i < n; i ++) {
//            if (nums[i] > nums[i - 1]) dp[i] = dp[i - 1] + 1;
//            res = Math.max(res, dp[i]);
//        }
        int res = 1, cur = 1;
        for (int i = 1; i < n; i ++) {
            cur = nums[i] > nums[i - 1] ? cur + 1 : 1;
            res = Math.max(res, cur);
        }
        return res;
    }
}
