package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * No.429 N叉树的层序遍历
 */
public class No_429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i ++) {
                Node node = queue.poll();
                List<Node> children = node.children;
                if (children.size() > 0) {
                    for (Node child : children) {
                        queue.offer(child);
                    }
                }
                list.add(node.val);
            }
            res.add(list);
        }

        return res;
    }
}


