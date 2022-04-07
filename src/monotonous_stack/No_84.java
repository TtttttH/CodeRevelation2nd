package monotonous_stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * No.84 柱状图中最大的矩形 (hard) Microsoft
 */
public class No_84 {
    /**
     * 思路: 该题其实是寻找当前下标柱子左右两边均高于该柱子的范围，可以使用单调栈或者双数组动态规划
     *
     */
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(right, len);
        Deque<Integer> deque = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < len; i ++) {
            while (!deque.isEmpty() && heights[i] < heights[deque.peek()]) {
                right[deque.pop()] = i;
            }
            left[i] = deque.isEmpty() ? -1 : deque.peek();
            deque.push(i);
        }

        for (int i = 0; i < len; i ++) {
            res = Math.max(res, heights[i] * (right[i] - left[i] + 1));
        }
        return res;
    }

}
