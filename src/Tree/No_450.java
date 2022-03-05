package Tree;

/**
 * No.450 删除二叉搜索树中的节点(middle) 微软题
 */
public class No_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val > key) root.left = deleteNode(root.left, key);
        if (root.val < key) root.right = deleteNode(root.right, key);
        if (root.val == key) {
            if (root.left == null && root.right == null) return null;
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode cur = root.left;
            while (cur.right != null) cur = cur.right;
            cur.right = root.right;
            return root.left;
        }

        return root;
    }
}
