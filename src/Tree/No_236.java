package Tree;

/**
 * No.236 二叉树的最近公共祖先 (middle) 微软题
 */
public class No_236 {
    boolean flag = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p) return p;
        if (root == q) return q;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        if (flag) return left;//优化逻辑，假如左边已经找到两个节点，则不再遍历右边的节点
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // if (left == null && right != null) return right;
        // if (left != null && right == null) return left;
        // if (left != null && right != null) return root;
        if (left == null && right == null) return null;
        if (left != null && right != null) {
            flag = true;
            return root;
        }
        return left == null ? right : left;
    }
}
