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
    private HashSet<Integer> set=new HashSet<>();
    private boolean found=false;
    private void inOrder(TreeNode root,int k){
        if(root==null){
            return;
        }
        inOrder(root.left,k);
        if(set.contains(k-root.val)){
            found=true;
            return;
        }
        set.add(root.val);
        inOrder(root.right,k);
    }
    public boolean findTarget(TreeNode root, int k) {
        inOrder(root,k);
        return found;
    }
}