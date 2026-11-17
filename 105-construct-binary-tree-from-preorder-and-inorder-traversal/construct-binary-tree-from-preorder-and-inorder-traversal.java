import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int preIndex = 0;
    private Map<Integer, Integer> inorderIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Store value -> index mapping for O(1) lookups in inorder
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return construct(preorder, 0, inorder.length - 1);
    }

    private TreeNode construct(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        // Pick current root from preorder and advance pointer
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        // Find root position in inorder to split left and right subtrees
        int inIndex = inorderIndexMap.get(rootVal);

        // Must build left subtree first because preorder visits Left before Right
        root.left = construct(preorder, inStart, inIndex - 1);
        root.right = construct(preorder, inIndex + 1, inEnd);

        return root;
    }
}