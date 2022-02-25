package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * No.226 翻转二叉树 easy
 */
public class No_226 {
    //迭代写法
    public TreeNode invertTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return root;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i ++) {
                TreeNode cur = deque.poll();
                TreeNode temp = cur.left;
                cur.left = cur.right;
                cur.right = temp;
                if (cur.left != null) deque.offer(cur.left);
                if (cur.right != null) deque.offer(cur.right);
            }
        }

        return root;
    }
}
