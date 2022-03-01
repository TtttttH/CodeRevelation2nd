package Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * No.105 Construct Binary Tree from Preorder and Inorder Traversal (middle) 微软题
 */
public class No_105 {
    Map<Integer, Integer> map = new HashMap<>();
    int[] preorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i ++) {
            map.put(inorder[i], i);
        }
        return helper(0, preorder.length, 0, inorder.length);
    }

    private TreeNode helper(int preLeft, int preRight, int inLeft, int inRight) {
        if (inRight - inLeft == 0) return null;
        int nodeVal = preorder[preLeft];
        int cutInIdx = map.get(nodeVal);
        TreeNode root = new TreeNode(nodeVal);

        int cutPreIdx = preLeft +1 + cutInIdx - inLeft;
        root.left = helper(preLeft + 1, cutPreIdx, inLeft, cutInIdx);
        root.right = helper(cutPreIdx, preRight, cutInIdx + 1, inRight);

        return root;
    }
}
