package greedy;

/**
 * No.968 监控二叉树(hard) 微软题
 */
public class No_968 {
    int count = 0;
    public int minCameraCover(TreeNode root) {
        if (helper(root) == 1) count ++;
        return count;
    }

    private int helper(TreeNode root) {
        if (root == null) return 2;
        int left = helper(root.left);
        int right = helper(root.right);

        if (left == 2 && right == 2) { //叶子节点
            return 1; //被监控
        }

        if (left == 1 || right == 1) { //左右节点有被当前节点监控，即root为摄像头节点
            count ++;
            return 0;
        }

        //if (left == 0 || right == 0) 两个子节点都是摄像头或者一个摄像头一个是空
        return 2;
    }
}
