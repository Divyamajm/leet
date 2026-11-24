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
    // private boolean x=true;
    // private Stack<Integer> s=new Stack<>();
    private void inOrder(TreeNode root,List<Integer>result){
        // Stack<Integer> s=new Stack<>();
        if(root==null){
            return;
        }
        inOrder(root.left,result);
        result.add(root.val);
        inOrder(root.right,result);
    }
    public boolean isValidBST(TreeNode root) {
        List<Integer>result=new ArrayList<>();
        inOrder(root,result);
        for(int i=1;i<result.size();i++){
            if(result.get(i)<=result.get(i-1)){
                return false;
            }
        }
        return true;
    }
}