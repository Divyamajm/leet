class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums,k)-atMost(nums,k-1);
    }
    private int atMost(int[] nums,int k){
        int l=0;
        int r=0;
        int n=nums.length-1;
        int total=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        while(r<=n){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(map.size()>k){
                map.put(nums[l],map.get(nums[l])-1);
                if(map.get(nums[l])==0){
                    map.remove(nums[l]);
                }
                l++;
            }
            total+=r-l+1;
            r++;
        }return total;
    }
}