package monotonous_stack;

import java.lang.reflect.Array;
import java.util.*;

/**
 * No.503 下一个更大元素II (middle) Microsoft
 */
public class No_503 {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        for (int i = 0; i < 2 * len; i ++) {
            int idx = i % len;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[idx]) {
                res[stack.pop()] = nums[idx];
            }
            if (i < len) stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,2,1,4};
        No_503 test = new No_503();
        int[] res = test.nextGreaterElements(nums);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
