package backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * No.77 组合问题
 */
public class No_77 {
    List<List<Integer>> result;
    public List<List<Integer>> combine(int n, int k) {
        if (k == 0 || n == 0) return result;
        for (int i = 1; i <= n - k; i ++) {
            backtrack(i, n, k, new ArrayList<>());
        }

        return result;
    }

    private void backtrack(int start, int n, int k, List<Integer> list) {
        if (k == 0) {
            result.add(new ArrayList<>(list));
        }
        for (int i = start; i <= n - k; i ++) {
            list.add(i);
            backtrack(i +1, n, k -1, list);
            list.remove(list.size() - 1);
        }
    }
}
