package monotonous_stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * No.42 接雨水(hard) Microsoft
 */
public class No_42 {
    /**
     * 单调最小栈解法
     * @param height
     * @return
     */
    public int trap(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < height.length; i ++) {
            //这里如果进来的高度等于当前栈最小高度也需要更新位置，否则计算矩形的宽将大于实际值
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                int low = height[stack.pop()];
                if (!stack.isEmpty()) {
                    int high = Math.min(height[stack.peek()], height[i]);
                    res += (i - stack.peek() - 1) * (high - low);
                }
            }
            stack.push(i);
        }

        return res;
    }

    public int trap_doublePoint(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int res = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                res += leftMax - height[left];
                left ++;
            } else {
                res += rightMax - height[right];
                right --;
            }
        }

        return res;
    }
}
