package Tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * No.116 填充每一个节点的下一个右侧节点指针 (middle) 微软题
 */
public class No_116 {
    public cNode connect(cNode root) {
        if (root == null) return null;
        Deque<cNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                cNode node = queue.poll();
                if (i == size - 1) {
                    node.next = null;
                } else {
                    node.next = queue.peek();
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return root;
    }
}

class cNode {
    public int val;
    public cNode left;
    public cNode right;
    public cNode next;

    public cNode() {}

    public cNode(int _val) {
        val = _val;
    }

    public cNode(int _val, cNode _left, cNode _right, cNode _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
