package dp.subsequence;

/**
 * No.718 Maximum Length of Repeated Subarray(middle) Microsoft
 */
public class No_718 {
    public int findLength(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int[][] dp = new int[n1 + 1][n2 + 1];
        int res = 0;
        for (int i = 0; i < n1; i ++) {
            for (int j = 0; j < n2; j ++) {
                if (nums1[i] == nums2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }
                res = Math.max(res, dp[i + 1][j + 1]);
            }
        }

        return res;
    }
}
