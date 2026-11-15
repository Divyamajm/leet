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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode>s=new Stack();
        List<Integer>result=new ArrayList();
        if(root==null){
            return result;
        }
        s.push(root);
        while(!s.isEmpty()){
            TreeNode temp=s.pop();
            result.add(temp.val);
            if(temp.right!=null){
                s.push(temp.right);
            }
            if(temp.left!=null){
                s.push(temp.left);
            }
        }
        return result;
    }
}