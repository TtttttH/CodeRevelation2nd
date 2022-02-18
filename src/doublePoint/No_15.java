package doublePoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No.15 三数之和 (middle)
 */
public class No_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3) {
            return ans;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] > 0) {
                return ans;
            }

            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == -nums[i]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ans.add(list);
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (left < right && nums[left] == nums[left + 1]) left ++;
                } else if (sum > -nums[i]) {
                    right--;
                } else {
                    left ++;
                }
            }
        }

        return ans;
    }
}
