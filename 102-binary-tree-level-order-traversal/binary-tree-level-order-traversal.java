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
    public void levelOrder(TreeNode root,List<List<Integer>>result,int level){
        if(root==null){
            return;
        }
        if(level==result.size()){
            result.add(new ArrayList());
        }
        result.get(level).add(root.val);
        levelOrder(root.left,result,level+1);
        levelOrder(root.right,result,level+1);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>result=new ArrayList<>();
        levelOrder(root,result,0);
        return result;
    }
}