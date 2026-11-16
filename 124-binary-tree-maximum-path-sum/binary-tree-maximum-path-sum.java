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
    public int max=Integer.MIN_VALUE;
    public int ord(TreeNode root){
        if(root==null){
            return 0;
        }
        int l=ord(root.left);
        int r=ord(root.right);
        if(l<0){
            l=0;
        }
        if(r<0){
            r=0;
        }
        max=Math.max(max,root.val+l+r);
        return root.val+Math.max(l,r);
    }
    public int maxPathSum(TreeNode root) {
        ord(root);
        return max;
    }
}