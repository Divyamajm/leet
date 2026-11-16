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
    public void levelOrder(TreeNode root,List<List<Integer>>result,int lvl){
        if(root==null){
            return;
        }
        if(lvl==result.size()){
            result.add(new ArrayList<>());
        }
        if(lvl%2==0){
            result.get(lvl).add(root.val);
        }
        else{
            result.get(lvl).add(0,root.val);
        }
        levelOrder(root.left,result,lvl+1);
        levelOrder(root.right,result,lvl+1);
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>result=new ArrayList();
        levelOrder(root,result,0);
        return result;
    }
}