class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result=new int[k];
        // PriorityQueue<Integer,Integer> q=new PriorityQueue<>();
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Integer>q=new PriorityQueue<>((a,b)->Integer.compare(map.get(a),map.get(b)));
        for(int key:map.keySet()){
            q.offer(key);
            if(q.size()>k){
                q.poll();
            }
        }
        for(int i=0;i<k;i++){
            result[i]=q.poll();
        }
        return result;
    }
}