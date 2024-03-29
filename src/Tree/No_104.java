package Tree;

/**
 * No.104 二叉树的最大深度 (easy)
 */
public class No_104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

//    private int maxDepth(TreeNode root, int depth) {
//        if (root == null) {
//            return depth;
//        }
//
//        return Math.max(maxDepth(root.left, depth + 1), maxDepth(root.right, depth + 1));
//    }
}
