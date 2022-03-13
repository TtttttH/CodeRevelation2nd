package greedy;

import java.util.Arrays;

/**
 * No.1005 K次取反后最大化的数组和(easy)
 */
public class No_1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int idx = 0;
        int minIdx = 0;
        for (int i = 0; i < k; i ++) {
            if (idx > nums.length - 1) {
                if ((k - i) % 2 == 1) nums[minIdx] = - nums[minIdx];
                break;
            }

            if (nums[idx] < 0) {
                nums[idx] = - nums[idx];
                minIdx = nums[minIdx] > nums[idx] ? idx : minIdx;
                idx ++;
            } else if (nums[idx] > 0 && ((k - i) % 2 == 1)) {
                minIdx = nums[minIdx] > nums[idx] ? idx : minIdx;
                nums[minIdx] = -nums[minIdx];
            } else break;
        }

        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        return sum;
    }
}
