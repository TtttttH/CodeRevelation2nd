package Hash;

import java.util.HashMap;

/**
 * No.1 两数之和(easy)
 */
public class No_01 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> valueIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            if (valueIndex.containsKey(target - nums[i])) {
                result[0] = valueIndex.get(target - nums[i]);
                result[1] = i;
                break;
            } else {
                valueIndex.put(nums[i], i);
            }
        }
        return result;
    }
}
