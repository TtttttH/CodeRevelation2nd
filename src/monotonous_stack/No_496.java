package monotonous_stack;

import java.util.*;

/**
 * No.496 下一个更大元素I (easy) Microsoft
 */
public class No_496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        for (int j : nums2) {
            while (!stack.isEmpty() && j > stack.peek()) {
                map.put(stack.pop(), j);
            }
            stack.push(j);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i ++) {
            res[i] = map.getOrDefault(nums1[i], - 1);
        }

        return res;
    }
}
