package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * No.144 二叉树前序遍历
 */
public class No_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root == null) return list;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
            list.add(node.val);
        }
        return list;
    }
//
//    private void traversal(TreeNode root, List<Integer> list) {
//        if (root == null) {
//            return;
//        }
//
//        list.add(root.val);
//        traversal(root.left,list);
//        traversal(root.right,list);
//    }
}
