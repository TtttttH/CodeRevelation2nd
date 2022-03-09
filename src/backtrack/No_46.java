package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * No.46 全排列(middle) 微软
 */
public class No_46 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int[] used;
    public List<List<Integer>> permute(int[] nums) {
        used = new int[nums.length];
        backtrack(nums, used);
        return result;
    }

    private void backtrack(int[] nums, int[] used) {
        if (path.size() == nums.length) result.add(new ArrayList<>(path));

        for (int i = 0; i < nums.length; i ++) {
            if (used[i] == 1) continue;
            path.add(nums[i]);
            used[i] = 1;
            backtrack(nums, used);
            used[i] = 0;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        No_46 test = new No_46();
        test.permute(nums);
        for (List<Integer> list : test.result) {
            for (int i : list) System.out.print(i + ",");
            System.out.println("");
        }
    }
}
