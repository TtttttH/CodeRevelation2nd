package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * No.501 二叉搜索树中的众数(easy) Morris解法 O(n), O(1)
 */
public class No_501_Morris {
    List<Integer> list = new ArrayList<>();
    int maxCnt, curCnt, preVal;
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        TreeNode cur = root, pre = null;
        while (cur != null) {
            if (cur.left == null) {
                update(cur);
                cur = cur.right;
                continue;
            }

            pre = cur.left; //将pre移动到左子节点
            while (pre.right != null && pre.right != cur) {
                pre = pre.right; //寻找cur左子树上的最右节点，该节点的下一个遍历节点及应该是cur
            }

            if (pre.right == null) { //该节点是第一次被遍历，将其右子树指向cur
                pre.right = cur;
                cur = cur.left; //注意这里要继续向cur左子树遍历
            } else { //说明cur节点的左子树已经遍历到最后一个节点,将pre.right 改回null
                pre.right = null;
                update(cur);
                cur = cur.right;
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i ++) {
            res[i] = list.get(i);
        }

        return res;
    }

    private void update(TreeNode cur) {
        if (cur == null) return;
        if (preVal == cur.val) curCnt ++;
        else {
            preVal = cur.val;
            curCnt = 1;
        }

        if (curCnt == maxCnt) {
            list.add(cur.val);
        } else if (curCnt > maxCnt) {
            list.clear();
            maxCnt = curCnt;
            list.add(cur.val);
        }
    }
}
