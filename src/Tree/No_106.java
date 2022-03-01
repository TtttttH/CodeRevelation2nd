package Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * No.106 Construct Binary Tree from inorder and Postorder Traversal (middle)
 */
public class No_106 {
    Map<Integer, Integer> inMap = new HashMap<>();
    int[] post;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i ++) {
            inMap.put(inorder[i], i);
        }

        post = postorder;
        return helper(0, inorder.length, 0, post.length);
    }

    private TreeNode helper(int inLeft, int inRight, int postLeft, int postRight) {
        if (inRight - inLeft == 0) return null;

        int rootVal = post[postRight - 1];
        int index = inMap.get(rootVal); //找到中序数组中的切割点位置
        TreeNode root = new TreeNode(rootVal);

        //根据两个数组的切割子数组长度相等关系得到后续数组切割位置
        int postIdx = postLeft + index - inLeft;
        root.left = helper(inLeft, index, postLeft, postIdx);
        root.right = helper(index + 1, inRight, postIdx, postRight - 1);
        return root;
    }
}
