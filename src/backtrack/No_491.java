package backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * No.491 递增子序列(middle) O(n*2^n)
 */
public class No_491 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null || nums.length < 2) return result;
        backtrack(nums, 0);
        return result;
    }

    private void backtrack(int[] nums, int start) {
        if (path.size() >= 2) result.add(new ArrayList<>(path));
        Set<Integer> set = new HashSet<>(); // 注意本题不能改变数组的元素顺序，所以去重无法直接比较上一个元素，需要hash
        for (int i = start; i < nums.length; i ++) {
            if (set.contains(nums[i]) || path.size() > 0 && path.get(path.size() - 1) > nums[i]) continue;
            path.add(nums[i]);
            set.add(nums[i]);
            backtrack(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
