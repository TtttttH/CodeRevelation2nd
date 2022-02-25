package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * No.637 二叉树的层平均值 (easy)
 */
public class No_637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            double sum = 0;
            for (int i = 0; i < size; i ++) {
                TreeNode node = deque.pop();
                sum += node.val;
                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
            }

            res.add(sum / size);
        }

        return res;
    }
}
