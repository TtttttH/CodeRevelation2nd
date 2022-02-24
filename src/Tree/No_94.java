package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * No.94 二叉树的中序遍历 (easy) 微软题，面试要求非递归写法，加自己建树验证
 */
public class No_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list =  new ArrayList<>();
        if (root == null) return list;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }

        return list;
    }
}
