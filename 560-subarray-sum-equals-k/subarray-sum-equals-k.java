class Solution {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        int n=nums.length;
        int total=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<n;i++){
            total+=nums[i];
            int remain=total-k;
            if(map.containsKey(remain)){
                count+=map.get(remain);
            }
            map.put(total,map.getOrDefault(total,0)+1);
        }
        return count;
    }
}