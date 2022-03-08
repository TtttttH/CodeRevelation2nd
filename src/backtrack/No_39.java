package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No.39 组合总和(middle) 微软
 * 1 <= candidates[i] <= 200
 */
public class No_39 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return result;
        Arrays.sort(candidates); //用来配合剪枝优化
        backtrack(candidates, target, 0, 0);
        return result;
    }

    private void backtrack(int[] candidates, int target, int sum, int start) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i ++) {
            if (sum + candidates[i] > target) break; //剪枝优化(需要配合排序使用)
            path.add(candidates[i]);
            backtrack(candidates, target, sum + candidates[i], i);
            path.remove(path.size() - 1);
        }
    }
}
