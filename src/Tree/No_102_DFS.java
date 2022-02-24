package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * No.102 层序遍历 DFS递归写法
 */
public class No_102_DFS {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        checkNode(root, 0);
        return res;
    }

    private void checkNode(TreeNode root, int deep) {
        if (root == null) return;
        deep ++;
        if (res.size() < deep) { //结果集size小于当前深度说明到达新层级，创建对应list
            List<Integer> list = new ArrayList<>();
            res.add(list);
        }

        res.get(deep - 1).add(root.val);
        checkNode(root.left, deep);
        checkNode(root.right, deep);
    }
}
