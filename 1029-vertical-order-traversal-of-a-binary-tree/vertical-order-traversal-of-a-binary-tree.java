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
class Tuple{
    TreeNode node;
    int row;
    int col;
    public Tuple(TreeNode node,int row,int col){
        this.node=node;
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Tuple>q=new LinkedList<Tuple>();
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>>map=new TreeMap<>();
        if(root!=null){
            q.offer(new Tuple(root,0,0));
        }
        while(!q.isEmpty()){
            Tuple tuple=q.poll();
            TreeNode t=tuple.node;
            int r=tuple.row;
            int c=tuple.col;
            map.putIfAbsent(c,new TreeMap<>());
            map.get(c).putIfAbsent(r,new PriorityQueue());
            map.get(c).get(r).offer(t.val);
            if(t.left!=null){
                q.offer(new Tuple(t.left,r+1,c-1));
            }
            if(t.right!=null){
                q.offer(new Tuple(t.right,r+1,c+1));
            }
        }
        List<List<Integer>>result=new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>>rows:map.values()){
            List<Integer>current=new ArrayList<>();
            for(PriorityQueue<Integer>pq:rows.values()){
                while(!pq.isEmpty()){
                    current.add(pq.poll());
                }
            }
            result.add(current);
        }
        return result;
    }
}