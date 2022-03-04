package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * No.501 二叉搜索树中的众数(easy)
 */
public class No_501 {
    int maxCnt, curCnt, preVal;
    List<Integer> ans = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        helper(root);
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i ++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (preVal == root.val) {
            curCnt ++;
        }
        if (curCnt == maxCnt) {
            ans.add(root.val);
        } else if (curCnt > maxCnt) {
            ans.clear();
            maxCnt = curCnt;
            ans.add(root.val);
        }
        helper(root.right);
    }
}
