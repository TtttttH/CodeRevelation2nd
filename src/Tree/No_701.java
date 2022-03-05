package Tree;

/**
 * No.701 二叉搜索树中的插入操作 (middle) 微软题
 */
public class No_701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        helper(root, val);
        return root;
    }


    private void helper(TreeNode root, int val) {
        if (root.val < val && root.right == null) {
            root.right = new TreeNode(val);
            return;
        }

        if (root.val > val && root.left == null) {
            root.left = new TreeNode(val);
            return;
        }

        if (root.val < val) helper(root.right, val);
        else helper(root.left, val);
    }
}
