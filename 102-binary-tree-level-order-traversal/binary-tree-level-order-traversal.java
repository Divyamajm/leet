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
    public void level(TreeNode root,List<List<Integer>>result,int lvl){
        if(root==null){
            return;
        }
        if(lvl==result.size()){
            result.add(new ArrayList<>());
        }
        result.get(lvl).add(root.val);
        level(root.left,result,lvl+1);
        level(root.right,result,lvl+1);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>result=new ArrayList<>();
        level(root,result,0);
        return result;
    }
}