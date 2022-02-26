package Tree;

/**
 * No.222 完全二叉树的节点个数 (middle) 微软题
 */
public class No_222 {
    public int countNodes(TreeNode root) {
        /** 非完全二叉树普通递归做法
         if (root == null) return 0;
         if (root.left == null && root.right == null) return 1;
         return countNodes(root.left) + countNodes(root.right) + 1;
         **/
        if (root == null) return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (left == right) return 1 << left + countNodes(root.right);
        else return 1 << right + countNodes(root.left);
    }

    private int getDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            depth ++;
            node = node.left;
        }

        return depth;
    }
}
