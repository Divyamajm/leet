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
        if(result.size()==lvl){
            result.add(new ArrayList());
        }
        result.get(lvl).add(root.val);
        levelOrder(root.left,result,lvl+1);
        levelOrder(root.right,result,lvl+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>>result=new ArrayList();
        List<Integer>right=new ArrayList<>();
        levelOrder(root,result,0);
        for(int i=0;i<result.size();i++){
            List<Integer>current=result.get(i);
            if(!current.isEmpty()){
                right.add(current.get(current.size()-1));
            }
        }
        return right;
    }
}