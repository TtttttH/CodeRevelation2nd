package backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No.40 组合总和II (middle) 微软
 * 时间复杂度: 最坏情况所有数字不同，且和均小于等于target, O(2^n * n)
 * 空间复杂度O(n)
 */
public class No_40 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return result;
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, 0);
        return result;
    }

    private void backtrack(int[] candidates, int target, int sum, int start) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i ++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            if (sum + candidates[i] > target) break;
            path.add(candidates[i]);
            backtrack(candidates, target, sum + candidates[i], i + 1);
            path.remove(path.size() - 1);
        }
    }

}
