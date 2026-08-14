class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Integer>q=new PriorityQueue<>((a,b)->Integer.compare(map.get(b),map.get(a)));
        q.addAll(map.keySet());
        return q.peek();
    }
}