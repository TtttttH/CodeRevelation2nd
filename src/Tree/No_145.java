package Tree;

import java.util.*;

/**
 * No.145 二叉树后序遍历
 */
public class No_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            list.add(cur.val);
            // 注意这里left先进栈后出栈，这样反转后left节点就在遍历前面
            if (cur.left != null) stack.push(cur.left);
            if (cur.right != null) stack.push(cur.right);
        }
        Collections.reverse(list);
        return list;
    }
}
