class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++){
            q.offer(stones[i]);
        }
        while(q.size()>1){
            int l=q.poll();
            int r=q.poll();
            if(l!=r){
                q.offer(l-r);
            }
        }
        return q.isEmpty() ? 0:q.poll();
    }
}