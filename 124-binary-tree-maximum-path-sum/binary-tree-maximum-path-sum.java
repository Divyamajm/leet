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
        int l=Math.max(0,ord(root.left));
        int r=Math.max(0,ord(root.right));
        int total=root.val+l+r;
        max=Math.max(max,total);
        return root.val+Math.max(l,r);
    }
    public int maxPathSum(TreeNode root) {
        max=Integer.MIN_VALUE;
        ord(root);
        return max;
    }
}