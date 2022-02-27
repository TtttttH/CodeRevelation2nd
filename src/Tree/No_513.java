package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * No.513 Find Bottom Left Tree Value (middle) 微软题
 */
public class No_513 {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int res = root.val;
        while (!queue.isEmpty()) {
//            int size = queue.size();
//            res = queue.peek().val;
//            for (int i = 0; i < size; i ++) {
//                TreeNode cur = queue.poll();
//                if (cur.left != null) queue.offer(cur.left);
//                if (cur.right != null) queue.offer(cur.right);
//            }
            TreeNode cur = queue.poll();
            res = cur.val;
            if (cur.right != null) queue.offer(cur.right);
            if (cur.left != null) queue.offer(cur.left);
        }

        return res;
    }
}
