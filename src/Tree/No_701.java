package Tree;

/**
 * No.701 二叉搜索树中的插入操作 (middle) 微软题
 */
public class No_701 {
//    public TreeNode insertIntoBST(TreeNode root, int val) {
//        if (root == null) return new TreeNode(val);
//        if (root.val > val) root.left = insertIntoBST(root.left, val);
//        if (root.val < val) root.right = insertIntoBST(root.right, val);
//        return root;
//    }
    //迭代法
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur != null) {
            parent = cur;
            if (cur.val < val) cur = cur.right;
            else cur = cur.left;
        }

        TreeNode node = new TreeNode(val);
        if (parent.val < val) parent.right = node;
        else parent.left = node;
        return root;
    }
}
