package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No.90 子集II (middle)
 */
public class No_90 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result.add(new ArrayList<>(path));
        Arrays.sort(nums);
        backtrack(nums, 0);
        return result;
    }

    private void backtrack(int[] nums, int start) {
        if (start == nums.length) return;
        for (int i = start; i < nums.length; i ++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            result.add(new ArrayList<>(path));
            backtrack(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
