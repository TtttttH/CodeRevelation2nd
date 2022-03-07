package backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * No.216 组合总和III (middle)
 */
public class No_216 {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k, n, 1, 0);
        return result;
    }

    private void backtrack(int k, int n, int start, int sum) {
        //剪枝
        if (path.size() > k) return;
        if (path.size() == k && sum == n) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < 10 && sum + i <= n; i ++) { //剪枝
            path.add(i);
            backtrack(k, n, i + 1, sum + i);
            path.remove(path.size() - 1);
        }
    }
}
