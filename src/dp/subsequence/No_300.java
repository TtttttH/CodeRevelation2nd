package dp.subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No.300 Longest Increasing Subsequence (middle) Microsoft
 */
public class No_300 {

    //dp method O(n^2)
    public int lengthOfLIS_dp(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 1; i < n; i ++) {
            for (int j = 0; j < i; j ++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    //binary search & greedy O(nlogn)
    public int lengthOfLIS_bs(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;
        int[] d = new int[n + 1];
        int res = 1;
        d[1] = nums[0];
        for (int i = 1; i < n; i ++) {
            if (nums[i] > d[res]) {
                res += 1;
                d[res] = nums[i];
            } else {
                int left = 1, right = res, pos = 0;
                while (left < right) {
                    int mid = left + ((right - left) >> 1); // !!!remember add ()
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }

        return res;
    }

    public List<Integer> getPath(int[] nums) {
        int n = nums.length;
        if (n == 0) return null;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        int index = 0;
        List<List<Integer>> paths = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[i]);
            paths.add(temp);
            for (int j = 0; j < i; j ++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] < dp[j] + 1) {
                        List<Integer> temp1 = new ArrayList<>(paths.get(j));
                        temp1.add(nums[i]);
                        paths.remove(i);
                        paths.add(temp1);
                    }
                }
            }
            if (max < dp[i]) {
                index = i;
                max = dp[i];
            }
        }

        return paths.get(index);
    }
}
