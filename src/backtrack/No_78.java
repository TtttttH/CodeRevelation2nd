package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * No.78 子集(middle) 微软 O(2^n)
 */
public class No_78 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        result.add(new ArrayList<>(path));
        backtrack(nums, 0);
        return result;
    }

    private void backtrack(int[] nums, int start) {
        if (start == nums.length) return;
        for (int i = start; i < nums.length; i ++) {
            path.add(nums[i]);
            result.add(new ArrayList<>(path));
            backtrack(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        No_78 test = new No_78();
        int[] nums = {1,2,3,4,5};
        test.subsets(nums);
        for (List<Integer> list : test.result) {
            for (int i : list) {
                System.out.print(i + ",");
            }
            System.out.println(" ");
        }
        System.out.println(test.result.size());
    }
}
