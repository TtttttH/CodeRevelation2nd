package Tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * No.530 二叉搜索树的最小绝对差(easy)
 */
public class No_530 {
    //关键思路，二叉搜索树中序遍历为递增序列
    public int getMinimumDifference(TreeNode root) {
        int res = Integer.MAX_VALUE;
        TreeNode pre = null;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            if (pre != null) {
                res = Math.min(res, Math.abs(cur.val - pre.val));
            }
            pre = cur;
            cur = cur.right;
        }

        return res;
    }
}
