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
    public int max=0;
    public int ord(TreeNode root){
        if(root==null){
            return 0;
        }
        int l=ord(root.left);
        int r=ord(root.right);
        max=Math.max(max,l+r);
        return 1+Math.max(l,r);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        // max=0;
        ord(root);
        return max;
    }
}