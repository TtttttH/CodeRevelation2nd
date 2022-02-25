package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * No.199 二叉树的右视图 (middle)
 */
public class No_199 {
    public List<Integer> rightSideView(TreeNode root) {
        //思路: 二叉树层序遍历，找出每一层最右边的元素，加入list即可
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i ++) {
                TreeNode node = deque.poll();
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
                i ++;
                if (i == size) list.add(node.val);
            }
        }
        return list;
    }
}
