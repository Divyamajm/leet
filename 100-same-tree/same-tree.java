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
    public void ord(TreeNode root,List<Integer>list){
        if(root==null){
            list.add(null);
            return;
        }
        list.add(root.val);
        ord(root.left,list);
        ord(root.right,list);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        List<Integer>result1=new ArrayList<>();
        List<Integer>result2=new ArrayList<>();
        ord(p,result1);
        ord(q,result2);
        if(result1.equals(result2)){
            return true;
        }
        return false;
    }
}