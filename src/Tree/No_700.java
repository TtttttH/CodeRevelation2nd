package Tree;

/**
 * No.700 二叉搜索树中的搜索(easy) 微软
 */
public class No_700 {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val == val) return cur;
            cur = cur.val < val ? cur.right : cur.left;
        }

        return null;
    }
}
