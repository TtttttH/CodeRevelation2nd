package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * No.257 Binary Tree Paths (easy)
 */
public class No_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> paths = new ArrayList<>();
        getPaths(res, paths, root);
        return res;
    }

    private void getPaths(List<String> res, List<Integer> paths, TreeNode node) {
        paths.add(node.val);
        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size(); i ++) {
                if (i != paths.size() - 1) {
                    sb.append(paths.get(i)).append("->");
                } else {
                    sb.append(paths.get(i));
                }
            }
            res.add(sb.toString());
            return;
        }

        if (node.left != null) {
            getPaths(res, paths, node.left);
            paths.remove(paths.size() - 1);
        }

        if (node.right != null) {
            getPaths(res, paths, node.right);
            paths.remove(paths.size() - 1);
        }
    }
}
