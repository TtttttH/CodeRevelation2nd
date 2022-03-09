package backtrack;

import java.util.*;

/**
 * No.47 全排列II(middle) 微软
 */
public class No_47 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        this.used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums);
        return result;
    }

    private void backtrack(int[] nums) {
        if (path.size() == nums.length) result.add(new ArrayList<>(path));
//        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i ++) {
//            if (set.contains(nums[i]) || used[i] == 1) continue;
            //注意这里的去重逻辑
            //used[i-1] == true, 说明在同一树支nums[i-1]使用过
            //used[i-1] == false, 说明在同一树层nums[i-1]使用过(因为当前树枝中没有用过nums[i-1],那么基于本层的遍历顺序,nums[i-1]会在nums[i]前调用，所以重复了

            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            used[i] = true;
//            set.add(nums[i]);
            path.add(nums[i]);
            backtrack(nums);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
