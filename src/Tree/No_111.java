package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * No.111 二叉树的最小深度(easy)
 */
public class No_111 {
    public int minDepth(TreeNode root) {
        //BFS
//        if (root == null) return 0;
//        int depth = 0;
//        Deque<TreeNode> deque = new ArrayDeque<>();
//        deque.offer(root);
//        while (!deque.isEmpty()) {
//            depth ++;
//            int size = deque.size();
//            for (int i = 0; i < size; i ++) {
//                TreeNode cur = deque.poll();
//                if (cur.left == null && cur.right == null) return depth;
//                if (cur.left != null) deque.offer(cur.left);
//                if (cur.right != null) deque.offer(cur.right);
//            }
//        }
//
//        return depth;
        //DFS
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }
}
