package dp.rob;

/**
 * No.337 打家劫舍III (middle) microsoft
 */
public class No_337 {
    public int rob(TreeNode root) {
        int[] result = MaxRob(root);
        return Math.max(result[0], result[1]);
    }

    private int[] MaxRob(TreeNode root) {
        if (root == null) return new int[]{0,0};
        int[] left = MaxRob(root.left);
        int[] right = MaxRob(root.right);

        //if rob root
        int robRoot = root.val + left[0] + right[0];

        //if dont' rob root
        int inrobRoot = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{inrobRoot, robRoot};
    }
}
