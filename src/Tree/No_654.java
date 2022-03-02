package Tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * No.654 最大二叉树(middle)
 */
public class No_654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 1) return new TreeNode(nums[0]);
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curNode = null;
        for (int num : nums) {
            curNode = new TreeNode(num);
            while (!stack.isEmpty() && stack.peek().val < num) {
                TreeNode top = stack.pop();
                if (!stack.isEmpty() && stack.peek().val < num) {
                    stack.peek().right = top;
                } else {
                    curNode.left = top;
                }
            }

            stack.push(curNode);
        }

        //遍历结束
        while (!stack.isEmpty()) {
            curNode = stack.pop();
            if (!stack.isEmpty()) {
                stack.peek().right = curNode;
            }
        }

        return curNode;
    }
//递归解法 O(n^2)
//    public TreeNode constructMaximumBinaryTree(int[] nums) {
//        return helper(nums, 0, nums.length);
//    }
//
//    private TreeNode helper(int[] nums, int left, int right) {
//        if (right - left == 0) return null;
//        if (right - left == 1) return new TreeNode(nums[left]);
//        int curIdx = getMax(nums, left, right);
//        TreeNode root = new TreeNode(nums[curIdx]);
//        root.left = helper(nums, left, curIdx);
//        root.right = helper(nums, curIdx + 1, right);
//        return root;
//    }
//
//    private int getMax(int[] nums, int left, int right) {
//        int max = left;
//        for (int i = left + 1; i < right; i ++) {
//            max = nums[max] < nums[i] ? i : max;
//        }
//
//        return max;
//    }
}
