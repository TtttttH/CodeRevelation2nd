package greedy;

import java.util.ArrayList;
import java.util.List;

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

    //进阶，返回最大子数组
    public List<Integer> maxSubArrayList(int[] nums) {
        int left = 0 ,right = 0, tempLeft = 0, res = nums[0], cur = res;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < nums.length; i ++) {
            if (cur > 0) cur += nums[i];
            else {
                cur = nums[i];
                tempLeft = i;
            }

            if (res <= cur) {
                res = cur;
                left = tempLeft;
                right = i;
            }
        }

        for (int i = left; i <= right; i ++) {
            list.add(nums[i]);
        }

        return list;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        No_53 test = new No_53();
        List<Integer> list = test.maxSubArrayList(nums);
        for (int i : list) {
            System.out.printf(i + ".");
        }
    }
}
