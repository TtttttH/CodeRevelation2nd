package StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * No.239 滑动窗口最大值 (hard 微软考过)
 */
public class No_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < k; i ++) {
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                queue.pollLast();
            }

            queue.offer(nums[i]);
        }

        int[] result = new int[nums.length - k + 1];
        result[0] = queue.peekFirst();
        for (int i = k; i < nums.length; i ++) {
            if (queue.peekFirst() == nums[i - k]) queue.pollFirst();
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                queue.pollLast();
            }
            queue.offer(nums[i]);
            result[i - k + 1] = queue.peekFirst();
        }

        return result;
    }
}
