class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int l=0;
        int r=0;
        int maxLength=0;
        int n=nums.length-1;
        while(r<=n&&l<=r){
            int c=nums[r];
            map.put(c,map.getOrDefault(c,0)+1);
            if(map.containsKey(c)&&map.get(c)>k){
                while(map.get(c)>k){
                    map.put(nums[l],map.get(nums[l])-1);
                    l++;
                }
                // l++;
            }
            maxLength=Math.max(maxLength,r-l+1);
            r++;
        }return maxLength;
    }
}