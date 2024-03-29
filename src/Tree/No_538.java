package Tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * No.538(1038) 把二叉搜索树转换为累加树 (middle)
 */
public class No_538 {
    private int pre = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convertBST(root.right);
        root.val += pre;
        pre = root.val;
        convertBST(root.left);
        return root;
//        TreeNode cur = root;
//        int cumulative = 0;
//        Deque<TreeNode> stack = new LinkedList<>();
//        while (cur != null || !stack.isEmpty()) {
//            while (cur != null) {
//                stack.push(cur);
//                cur = cur.right;
//            }
//            cur = stack.pop();
//            cur.val += cumulative;
//            cumulative = cur.val;
//            cur = cur.left;
//        }
//
//        return root;
    }
}
